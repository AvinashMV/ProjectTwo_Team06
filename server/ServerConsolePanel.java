package server;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * 
 * @author
 * @version 1.0
 */
public class ServerConsolePanel extends JPanel implements Observer {
	JTextArea consoleLogs;

	public ServerConsolePanel() {
		// createAndShowGUI();
	}

	void createAndShowGUI() {
		Border line = BorderFactory.createLineBorder(ServerConstants.LIGHT_BLUE, 5);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		this.setBorder(BorderFactory.createCompoundBorder(line, loweredbevel));
		this.setBackground(ServerConstants.SLATE_GREY);
		consoleLogs = new JTextArea();
		consoleLogs.setEditable(false);
		consoleLogs.setText("");
		consoleLogs.setPreferredSize(new Dimension(750, 150));
		consoleLogs.setBackground(ServerConstants.SLATE_GREY);
		consoleLogs.setText("Console\n\n\nServer is not running. \n");
		JScrollPane scroll = new JScrollPane(consoleLogs);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setEnabled(true);
		scroll.setVisible(true);
		this.add(scroll);
		// this.add(consoleLogs);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o.getClass().getName().equals("server.MessageObservable")) {
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
