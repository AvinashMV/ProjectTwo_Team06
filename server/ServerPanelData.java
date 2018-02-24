package server;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

/**
 * The ServerPanelConsole class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerPanelData extends JPanel {
	ServerStatusPanel serverStatusPanel;
	ServerControlPanel serverControlPanel;
	JSplitPane splitPane;

	/*
	 * Sets the look and feel of the Sever Data Panel and sets value
	 * 
	 */
	public ServerPanelData() {
		setLayout(new GridLayout());
		setPreferredSize(new Dimension(400, 400));
		setBackground(ServerConstants.PINK);
		try {
			serverStatusPanel = new ServerStatusPanel();
			MessageHandler.getInstance().setServerStatusPanel(serverStatusPanel);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		serverControlPanel = new ServerControlPanel();
		JSplitPane splitPane = new JSplitPane();
		Border line = BorderFactory.createLineBorder(ServerConstants.LIGHT_BLUE, 5);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		setBorder(BorderFactory.createCompoundBorder(line, loweredbevel));
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(400);
		splitPane.setLeftComponent(serverStatusPanel);
		splitPane.setRightComponent(serverControlPanel);
		add(splitPane);
	}
}
