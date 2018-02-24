package client;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * ClientPanelInfo class initializes the attributes for info panel
 * 
 * @author Team 06
 */
public class ClientPanelInfo extends JPanel {

	public ClientPanelInfo() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ClientPanelHighest highest = new ClientPanelHighest();
		ClientPanelLowest lowest = new ClientPanelLowest();
		ClientPanelAverage average = new ClientPanelAverage();
		ClientPanelChannels channels = new ClientPanelChannels();
		ClientPanelFrequency frequency = new ClientPanelFrequency();
		add(highest);
		add(lowest);
		add(average);
		add(channels);
		add(frequency);
	}
}