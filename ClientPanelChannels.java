
//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 */
public class ClientPanelChannels extends JPanel {

	private String[] valuesForDropDown = new String[] { "1", "2", "3", "4", "5" };
	JComboBox<String> channelDD;

	public ClientPanelChannels() {
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		JPanel test = new JPanel();
		JLabel channelLabel = new JLabel("<html>Channels:</html>");

		channelLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		channelLabel.setSize(85, 60);
		test.setPreferredSize(new Dimension(85, 60));
		test.setBackground(StandardColor.PINK);
		test.setBorder(BorderFactory.createLineBorder(Color.black));

		// added text panel where the lowest value will go.
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
