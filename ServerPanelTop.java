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
	Thread serverThread = new Thread(new Serversocket());
    /*
    Create the Top of the Server Window
    */	
    public ServerPanelTop() {
        createAndShowGUI();
    }
    
    /*
    Initialize the components of the Top of the Server Window
    */
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
	/*
	The functionality of the start and stop buttons:when clicked start the serverthread starts and 
	when stopped the serversocket will close the connection.
	*/
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();
		if(button.getText().equals("Start")) {
			button.setText("Stop");
			serverThread.start();
			observable.changeData("Start");
			
		}
		else {
			button.setText("Start");
			Serversocket.ServersocketClose();
			serverThread.stop();
			observable.changeData("Stop");
		}
		
	}

	

	
}
