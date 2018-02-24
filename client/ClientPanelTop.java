package client;
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

import javafx.beans.Observable;
import server.MessageHandler;
import server.ServerSocketMain;

/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 * @author SER 516, Rishabh Modi (#75)
 */
public class ClientPanelTop extends JPanel implements ActionListener {

	ServerSocketMain serverSocketMain = new ServerSocketMain();
	ExecutorService executor = Executors.newFixedThreadPool(10);
	ClientSocketMain clientSocketMain;
	ClientConsoleObserver clientConsoleObserver ; 

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
		clientConsoleObserver = new ClientConsoleObserver();
		clientConsoleObserver.addObserver(ClientDataManager.getInstance().getPanelConsole());
		add(test);
		add(startStop);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("Start")) {
			int frequency = getValueOfFrequency();
			if(frequency == -1) {
				return;
			}
			button.setText("Stop");
			clientConsoleObserver.changeData("Start");
			clientSocketMain = new ClientSocketMain();
			ClientDataManager.getInstance().initializeArray();
			startServer(frequency);
			
		} else {
			button.setText("Start");
			clientConsoleObserver.changeData("Stop");
			stopServer();
		}

	}



	private int getValueOfFrequency() {
		JTextPane frequencyTxt = ClientDataManager.getInstance().getFreqText();
		String frequency = frequencyTxt.getText().replace(",","");
		try {
			Integer freq = Integer.parseInt(frequency);
			if(freq <=0) {
				throw new NumberFormatException();
			}
			return freq;
		}
		catch(NumberFormatException e) {
			clientConsoleObserver.changeData("Please enter a valid frequency \n");
			return -1;
		}
		
		
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
