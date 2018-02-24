package server;

import javax.swing.JPanel;

/**
 * The ServerControlPanel class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerControlPanel extends JPanel {

	/*
	 * 
	 */
	public ServerControlPanel() {
		setBackground(ServerConstants.SLATE_GREY);
		ServerPanelHighest highest = new ServerPanelHighest();
		ServerPanelLowest lowest = new ServerPanelLowest();
		ServerPanelFrequency frequency = new ServerPanelFrequency();
		add(highest);
		add(lowest);
		add(frequency);
	}
}
