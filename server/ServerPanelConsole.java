package server;

//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Rishab Mantri (#69)
 */
public class ServerPanelConsole extends JPanel implements Observer {
	JTextArea consoleLogs;

	public ServerPanelConsole() {
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		Border line = BorderFactory.createLineBorder(StandardColor.LIGHT_BLUE, 5);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		setBorder(BorderFactory.createCompoundBorder(line, loweredbevel));
		JLabel test = new JLabel("CONSOLE");
		// test.setPreferredSize(new Dimension(600, 150));
		setBackground(StandardColor.SLATE_GREY);
		consoleLogs = new JTextArea();
		consoleLogs.setPreferredSize(new Dimension(600, 150));
		consoleLogs.setText("Server is not running. \n");
		add(test);
		add(consoleLogs);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o.getClass().getName().equals("server.MessageObservable")) {
			String message = (String) arg;
			System.out.println(message);
			if (message.equals("Start")) {
				message = "The server has been started. \n";
			} else {
				message = "The server has been stopped \n";
			}
			consoleLogs.append(message);
		}
		if(o.getClass().getName().equals("server.InputObservable")) {
			String message = (String) arg;
			consoleLogs.append(message);
		}

	}
}
