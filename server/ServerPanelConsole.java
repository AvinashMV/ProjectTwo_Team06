package server;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import com.sun.corba.se.spi.activation.Server;

/**
 * The ServerPanelConsole class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerPanelConsole extends JPanel implements Observer {
	JTextArea consoleLogs;

	/*Sets the display and data values for the Server Console
	 * 
	 */
	public ServerPanelConsole() {
		Border line = BorderFactory.createLineBorder(ServerConstants.LIGHT_BLUE, 5);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		setBorder(BorderFactory.createCompoundBorder(line, loweredbevel));
		JLabel consoleLabel = new JLabel(ServerConstants.CONSOLE);
		setBackground(ServerConstants.SLATE_GREY);
		consoleLogs = new JTextArea();
		consoleLogs.setPreferredSize(new Dimension(600, 150));
		consoleLogs.setText("Server is not running. \n");
		consoleLogs.setAutoscrolls(true);
		add(consoleLabel);
		JScrollPane scroll = new JScrollPane(consoleLogs, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(750, 150));
		scroll.setEnabled(true);
		scroll.setVisible(true);
		scroll.setAutoscrolls(true);
		this.add(scroll);
	}

	/*
	 * Printing messages of the server status on the console
	 * @param observable
	 * 
	 * @param arg
	 */
	@Override

	public void update(Observable observable, Object arg) {
		if (observable.getClass().getName().equals(ServerConstants.MESSAGE_OBSERVABLE)) {
			String message = (String) arg;
			if (message.equals(ServerConstants.START)) {
				message = ServerConstants.START_MESSAGE;
			} else {
				message = ServerConstants.STOP_MESSAGE;
			}
			consoleLogs.append(message);
		}

		if(observable.getClass().getName().equals(ServerConstants.INPUT_OBSERVABLE)) {
			String message = (String) arg;
			consoleLogs.append(message);
		}
	}
}
