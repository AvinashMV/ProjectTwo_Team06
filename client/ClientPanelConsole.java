package client;

import java.awt.Dimension;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javafx.beans.Observable;

/**
 * ClientPanelConsole class initializes and set ups attributes for panel
 * 
 * @author Team 6
 *
 */
public class ClientPanelConsole extends JPanel implements Observer {
	JTextArea consoleLogs;

	public ClientPanelConsole() {
		Border line = BorderFactory.createLineBorder(ClientConstants.LIGHT_BLUE, 5);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		setBorder(BorderFactory.createCompoundBorder(line, loweredbevel));
		JLabel test = new JLabel("CONSOLE");
		consoleLogs = new JTextArea();
		consoleLogs.setPreferredSize(new Dimension(600, 150));
		consoleLogs.setText("Not connected to server. \n");
		setBackground(ClientConstants.SLATE_GREY);
		add(test);
		add(consoleLogs);
	}

	@Override
	public void update(java.util.Observable o, Object arg) {
		String message = (String) arg;
		if (message.equals("Start")) {
			consoleLogs.append("Client has started \n");
		} else if (message.equals("Stop")) {
			consoleLogs.append("Client has stopped \n");
		} else {
			consoleLogs.append(message);
		}

	}
}