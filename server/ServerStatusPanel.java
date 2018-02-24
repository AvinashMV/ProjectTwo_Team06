package server;

import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The ServerStatusPanel class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerStatusPanel extends JPanel implements Observer {
	JLabel imageLabel;

	/*
	 * 
	 */
	public ServerStatusPanel() throws MalformedURLException {
		setBackground(ServerConstants.SLATE_GREY);
		imageLabel = new JLabel();
		imageLabel.setText(ServerConstants.SERVER_STATUS_STOP);
		imageLabel.setFont(ServerConstants.TEXT_FONT);
		add(imageLabel);
	}

	/*
	 * @param observable
	 * 
	 * @param arg
	 */
	@Override
	public void update(Observable observable, Object arg) {
		String status = (String) arg;
		if (status.equals(ServerConstants.START)) {
			imageLabel.setIcon(
					new ImageIcon(ServerStatusPanel.this.getClass().getResource(ServerConstants.SERVER_START_IMAGE)));
			imageLabel.setHorizontalTextPosition(JLabel.CENTER);
		} else {
			imageLabel.setIcon(null);
		}
	}
}
