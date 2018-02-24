package client;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import server.StandardColor;

/**
 * ClientPanelChannels class creates the channel component on UI
 * 
 * @author Team 6
 */
public class ClientPanelChannels extends JPanel {

	private String[] valuesForDropDown = new String[] { "1", "2", "3", "4", "5" };
	JComboBox<String> channelDD;

	public ClientPanelChannels() {
		JPanel test = new JPanel();
		JLabel channelLabel = new JLabel("<html>Channels:</html>");
		channelLabel.setFont(ClientConstants.TEXT_FONT);
		channelLabel.setSize(85, 60);
		test.setPreferredSize(new Dimension(85, 60));
		test.setBackground(StandardColor.PINK);
		test.setBorder(BorderFactory.createLineBorder(Color.black));
		channelDD = new JComboBox<String>(valuesForDropDown);
		channelDD.setPreferredSize(new Dimension(85, 60));
		channelDD.setVisible(true);
		channelDD.setBorder(BorderFactory.createLineBorder(Color.black));
		channelDD.setBackground(StandardColor.LIGHT_BLUE);
		ClientDataManager.getInstance().setChannelDD(channelDD);
		add(test);
		test.add(channelLabel);
		add(channelDD);
	}
}