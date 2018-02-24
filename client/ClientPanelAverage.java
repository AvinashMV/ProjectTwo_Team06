package client;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import server.ServerConstants;

/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 * @author SER 516, Vimal Menon (#73)
 */
public class ClientPanelAverage extends JPanel {

	public ClientPanelAverage() {
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		JPanel test = new JPanel();
		JLabel avgLabel = new JLabel("<html>Average<br>Value</html>");

		avgLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		avgLabel.setSize(85, 60);
		test.setPreferredSize(new Dimension(85, 60));
		test.setBackground(ServerConstants.LIGHT_BLUE);
		test.setBorder(BorderFactory.createLineBorder(Color.black));

		// added text panel where the average value will go.
		JTextPane avgText = new JTextPane();
		ClientDataManager.getInstance().setAvgText(avgText);
		avgText.setBorder(BorderFactory.createLineBorder(Color.black));
		avgText.setBackground(ServerConstants.PINK);
		avgText.setPreferredSize(new Dimension(85, 60));
		avgText.setEditable(false);

		add(test);
		test.add(avgLabel);
		add(avgText);
	}

	public static int getAvgValue(int[] array) {
		int sumValue = 0;
		int avgValue = 0;
		for (int i = 0; i < array.length; i++)
			sumValue = sumValue + array[i];
		avgValue = sumValue / array.length;
		return avgValue;
	}
}
