package client;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import server.ServerConstants;

/**
 * ClientPanelLowest class initializes the attributes for lowest value panel
 * 
 * @author Team 6
 */
public class ClientPanelLowest extends JPanel {

	public ClientPanelLowest() {
		JPanel test = new JPanel();
		JLabel lowLabel = new JLabel(ClientConstants.LOWEST_VALUE);
		lowLabel.setFont(ClientConstants.TEXT_FONT);
		lowLabel.setSize(85, 60);
		test.setPreferredSize(new Dimension(85, 60));
		test.setBackground(ServerConstants.PINK);
		test.setBorder(BorderFactory.createLineBorder(Color.black));
		JTextPane lowTxt = new JTextPane();
		ClientDataManager.getInstance().setLowTxt(lowTxt);
		lowTxt.setBorder(BorderFactory.createLineBorder(Color.black));
		lowTxt.setBackground(ServerConstants.LIGHT_BLUE);
		lowTxt.setPreferredSize(new Dimension(85, 60));
		lowTxt.setEditable(false);
		add(test);
		test.add(lowLabel);
		add(lowTxt);
	}

	/*
	 * getMinValue function calculates the minimum value from array of input data
	 */
	public static int getMinValue(int[] array) {
		int minValue = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < minValue) {
				minValue = array[i];
			}
		}
		return minValue;
	}
}