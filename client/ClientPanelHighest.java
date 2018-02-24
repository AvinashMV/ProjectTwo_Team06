package client;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * ClientPanelHighest class creates components for highest values
 * 
 * @author Team 6
 */
public class ClientPanelHighest extends JPanel {

	public ClientPanelHighest() {
		JPanel clientPanel = new JPanel();
		JLabel highLabel = new JLabel(ClientConstants.HIGHEST_VALUE);
		highLabel.setFont(ClientConstants.TEXT_FONT);
		highLabel.setSize(85, 60);
		clientPanel.setPreferredSize(new Dimension(85, 60));
		clientPanel.setBackground(ClientConstants.LIGHT_BLUE);
		clientPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		JTextPane highTxt = new JTextPane();
		ClientDataManager.getInstance().setHighTxt(highTxt);
		highTxt.setBorder(BorderFactory.createLineBorder(Color.black));
		highTxt.setBackground(ClientConstants.PINK);
		highTxt.setPreferredSize(new Dimension(85, 60));
		highTxt.setEditable(false);
		add(clientPanel);
		clientPanel.add(highLabel);
		add(highTxt);
	}

	/*
	 * Function returns the maximum value from the array of input data
	 * 
	 * @param array: array of input numbers
	 */
	public static int getMaxValue(int[] array) {
		int maxValue = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}
		return maxValue;
	}
}