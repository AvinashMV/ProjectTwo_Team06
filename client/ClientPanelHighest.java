package client;

//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import server.ServerConstants;


/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 * @author SER 516, Vimal Menon (#73)
 */
public class ClientPanelHighest extends JPanel {

	public ClientPanelHighest() {
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		JPanel test = new JPanel();
		JLabel highLabel = new JLabel("<html>Highest<br>Value</html>");

		highLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		highLabel.setSize(85, 60);
		test.setPreferredSize(new Dimension(85, 60));
		test.setBackground(ServerConstants.LIGHT_BLUE);
		test.setBorder(BorderFactory.createLineBorder(Color.black));

		// added text panel where the highest value will go.
		JTextPane highTxt = new JTextPane();
		ClientDataManager.getInstance().setHighTxt(highTxt);
		highTxt.setBorder(BorderFactory.createLineBorder(Color.black));
		highTxt.setBackground(ServerConstants.PINK);
		highTxt.setPreferredSize(new Dimension(85, 60));
		highTxt.setEditable(false);

		add(test);
		test.add(highLabel);
		add(highTxt);
	}

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
