package client;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import server.StandardColor;

/**
 * ClientPanelAverage class creates GUI object for average data display
 * 
 * @author Team 06
 */
public class ClientPanelAverage extends JPanel {

	public ClientPanelAverage() {
		JPanel clientPanel = new JPanel();
		JLabel averageLabel = new JLabel(ClientConstants.AVERAGE_LABEL);
		JTextPane avgText = new JTextPane();
		averageLabel.setFont(ClientConstants.TEXT_FONT);
		averageLabel.setSize(85, 60);
		clientPanel.setPreferredSize(new Dimension(85, 60));
		clientPanel.setBackground(StandardColor.LIGHT_BLUE);
		clientPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		ClientDataManager.getInstance().setAvgText(avgText);
		avgText.setBorder(BorderFactory.createLineBorder(Color.black));
		avgText.setBackground(StandardColor.PINK);
		avgText.setPreferredSize(new Dimension(85, 60));
		avgText.setEditable(false);
		add(clientPanel);
		clientPanel.add(averageLabel);
		add(avgText);
	}

	/*
	 * getAvgValue function returns the average calculated from array
	 * 
	 * @param array : server data values
	 * 
	 * @return : returns the average value
	 */
	public static int getAvgValue(int[] array) {
		int sumValue = 0;
		int avgValue = 0;
		for (int i = 0; i < array.length; i++)
			sumValue = sumValue + array[i];
		avgValue = sumValue / array.length;
		return avgValue;
	}
}