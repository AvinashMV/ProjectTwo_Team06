//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Rishab Mantri (#69)
 */
public class ServerPanelTop extends JPanel implements ActionListener{
	JButton serverControlButton;
	MessageObservable observable;
	
    public ServerPanelTop() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        JLabel test = new JLabel("TOP");
        serverControlButton =  new JButton();
        test.setPreferredSize(new Dimension(600, 50));
        setBackground(StandardColor.LIGHT_BLUE);
        serverControlButton.setText("Start");
        serverControlButton.setBackground(Color.PINK);
        serverControlButton.addActionListener(this);
        add(test);
        add(serverControlButton);
        observable = new MessageObservable();
        observable.addObserver(MessageHandler.getInstance().getServerStatusPanel());
        observable.addObserver(MessageHandler.getInstance().getServerPanelConsole());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if(button.getText().equals("Start")) {
			button.setText("Stop");
			observable.changeData("Start");
		}
		else {
			button.setText("Start");
			observable.changeData("Stop");
		}
		
	}

	

	
}
