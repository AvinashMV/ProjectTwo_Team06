import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 */
public class ClientPanelFrequency extends JPanel {
    
	public Color LIGHTBLUE = new Color(173,216,230);

    public Color LIGHTPINK = new Color(255,182,193);

    public ClientPanelFrequency() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
    	JPanel test = new JPanel();
        JLabel freqLabel = new JLabel("<html>Frequency<br>(Hz)</html>");
        
        freqLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        freqLabel.setSize(85, 60);
        test.setPreferredSize(new Dimension(85, 60));
        test.setBackground(LIGHTBLUE);
        test.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //added text panel where the frequency value will go.
        JTextPane freqText = new JTextPane();
        freqText.setBorder(BorderFactory.createLineBorder(Color.black));
        freqText.setBackground(LIGHTPINK);
        freqText.setPreferredSize(new Dimension(85, 60));
        freqText.setEditable(false);
        
        add(test);
        test.add(freqLabel);
        add(freqText);
    }
}
