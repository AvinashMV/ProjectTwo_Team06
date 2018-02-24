package server;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * The ServerPanelConsole class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerPanelConsole extends JPanel implements Observer {
	JTextArea consoleLogs;

	public ServerPanelConsole() {
		Border line = BorderFactory.createLineBorder(ServerConstants.LIGHT_BLUE, 5);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		setBorder(BorderFactory.createCompoundBorder(line, loweredbevel));
		JLabel consoleLabel = new JLabel(ServerConstants.CONSOLE);
		setBackground(ServerConstants.SLATE_GREY);
		consoleLogs = new JTextArea();
		consoleLogs.setPreferredSize(new Dimension(600, 150));
		consoleLogs.setText(ServerConstants.SERVER_STATUS_STOP);
		add(consoleLabel);
		add(consoleLogs);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o.getClass().getName().equals(ServerConstants.MESSAGE_OBSERVABLE)) {
			String message = (String) arg;
			if (message.equals(ServerConstants.START)) {
				message = ServerConstants.START_MESSAGE;
			} else {
				message = ServerConstants.STOP_MESSAGE;
			}
			consoleLogs.append(message);
		}
	}
}
