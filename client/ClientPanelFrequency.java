package client;

//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import server.ServerConstants;


/**
 * ClientPanelFrequency class sets attribute for frequency GUI components
 * 
 * @author Team 6
 */
public class ClientPanelFrequency extends JPanel {

	JTextPane freqText;

	public ClientPanelFrequency() {
		JPanel test = new JPanel();
		JLabel freqLabel = new JLabel("<html>Frequency<br>(Hz)</html>");

		freqLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		freqLabel.setSize(85, 60);
		test.setPreferredSize(new Dimension(85, 60));
		test.setBackground(ServerConstants.LIGHT_BLUE);
		test.setBorder(BorderFactory.createLineBorder(Color.black));

		freqText = new JTextPane();
		freqText.setBorder(BorderFactory.createLineBorder(Color.black));
		freqText.setBackground(ServerConstants.PINK);
		freqText.setPreferredSize(new Dimension(85, 60));
		ClientDataManager.getInstance().setFreqText(freqText);
		add(test);
		test.add(freqLabel);
		add(freqText);
	}

}
