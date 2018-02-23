package server;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author
 * @version 1.0
 */
public class ServerStatusPanel extends JPanel implements Observer {

	JLabel picLabel;

	public ServerStatusPanel() {

		// createLayout();
		// createAndShowGUI();
	}

	void createAndShowGUI() {
		this.setSize(400, 500);
		this.setBackground(ServerConstants.SLATE_GREY);
		picLabel = new JLabel();
		picLabel.setText(ServerConstants.SERVER_STATUS_STOP);
		picLabel.setFont(ServerConstants.TEXT_FONT);
		this.add(picLabel);
	}

	private Icon fetchIcon() {
		URL url = null;
		try {
			url = new URL("https://mir-s3-cdn-cf.behance.net/project_modules/source/e2a03d31641415.565a78be188d4.gif");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new ImageIcon(url);
	}

	@Override
	public void update(Observable o, Object arg) {
		String status = (String) arg;
		if (status.equals("Start")) {
			picLabel.setIcon(fetchIcon());
		} else {
			picLabel.setIcon(null);
		}

	}
	/*
	 * public static void main(String[] args) { ServerStatusPanel scp = new
	 * ServerStatusPanel(); scp.createAndShowGUI(); JFrame frame = new JFrame();
	 * frame.add(scp); frame.pack(); frame.setResizable(false);
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setVisible(true);
	 * }
	 */
}
