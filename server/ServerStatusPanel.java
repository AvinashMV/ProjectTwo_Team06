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
	JLabel picLabel;

	public ServerStatusPanel() throws MalformedURLException {
		setBackground(ServerConstants.SLATE_GREY);
		picLabel = new JLabel();
		picLabel.setText(ServerConstants.SERVER_STATUS_STOP);
		picLabel.setFont(ServerConstants.TEXT_FONT);
		add(picLabel);
	}

	@Override
	public void update(Observable o, Object arg) {
		String status = (String) arg;
		if (status.equals(ServerConstants.START)) {
			picLabel.setIcon(
					new ImageIcon(ServerStatusPanel.this.getClass().getResource(ServerConstants.SERVER_START_IMAGE)));
			picLabel.setHorizontalTextPosition(JLabel.CENTER);
		} else {
			picLabel.setIcon(null);
		}
	}
}
