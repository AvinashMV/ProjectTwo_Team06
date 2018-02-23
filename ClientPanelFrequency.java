
//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 */
public class ClientPanelFrequency extends JPanel {

	JTextPane freqText;

	public ClientPanelFrequency() {
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		JPanel test = new JPanel();
		JLabel freqLabel = new JLabel("<html>Frequency<br>(Hz)</html>");

		freqLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		freqLabel.setSize(85, 60);
		test.setPreferredSize(new Dimension(85, 60));
		test.setBackground(StandardColor.LIGHT_BLUE);
		test.setBorder(BorderFactory.createLineBorder(Color.black));

		// added text panel where the frequency value will go.
		freqText = new JTextPane();
		freqText.setBorder(BorderFactory.createLineBorder(Color.black));
		freqText.setBackground(StandardColor.PINK);
		freqText.setPreferredSize(new Dimension(85, 60));
		ClientDataManager.getInstance().setFreqText(freqText);
		add(test);
		test.add(freqLabel);
		add(freqText);
	}
}
