package client;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import server.StandardColor;

/**
 * ClientPanelHighest class creates components for highest values
 * 
 * @author Team 6
 */
public class ClientPanelHighest extends JPanel {

	public ClientPanelHighest() {
		JPanel test = new JPanel();
		JLabel highLabel = new JLabel(ClientConstants.HIGHEST_VALUE);
		highLabel.setFont(ClientConstants.TEXT_FONT);
		highLabel.setSize(85, 60);
		test.setPreferredSize(new Dimension(85, 60));
		test.setBackground(StandardColor.LIGHT_BLUE);
		test.setBorder(BorderFactory.createLineBorder(Color.black));
		JTextPane highTxt = new JTextPane();
		ClientDataManager.getInstance().setHighTxt(highTxt);
		highTxt.setBorder(BorderFactory.createLineBorder(Color.black));
		highTxt.setBackground(StandardColor.PINK);
		highTxt.setPreferredSize(new Dimension(85, 60));
		highTxt.setEditable(false);
		add(test);
		test.add(highLabel);
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