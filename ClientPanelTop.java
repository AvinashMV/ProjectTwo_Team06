import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 * @author SER 516, Rishabh Modi (#75)
 */
public class ClientPanelTop extends JPanel implements ActionListener {
    
	ServerSocketMain serverSocketMain = new ServerSocketMain();
	ExecutorService executor = Executors.newFixedThreadPool(10);
	ClientSocketMain clientSocketMain;
	
    public ClientPanelTop() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        JPanel test = new JPanel();
        test.setPreferredSize(new Dimension(560, 50));        
        JButton startStop = new JButton();
        startStop.addActionListener(this);
        startStop.setText("Start");
        startStop.setBackground(Color.pink);
        startStop.setBorder(BorderFactory.createLineBorder(Color.black));
        startStop.setPreferredSize(new Dimension(100, 50));
        add(test);
        add(startStop);
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if(button.getText().equals("Start")) {
			clientSocketMain = new ClientSocketMain();
			button.setText("Stop");
			ClientDataManager.getInstance().initializeArray();
			startServer(getValueOfFrequency());
		}
		else {
			button.setText("Start");
			stopServer();
		}
		
	}

	private int  getValueOfFrequency() {
		JTextPane frequencyTxt = ClientDataManager.getInstance().getFreqText();
		String frequency  = frequencyTxt.getText();
		Integer freq = Integer.parseInt(frequency);
		return freq;
	}

	private void startServer(int frequency) {
		Runnable runnableTask = () -> {
			clientSocketMain.startConnection(frequency);
		};
		executor.execute(runnableTask);
	}
	
	private void stopServer() {
		clientSocketMain.closeConnection();
		executor.shutdown();
	}
}
