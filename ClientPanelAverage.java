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
public class ClientPanelAverage extends JPanel {
    
	public Color LIGHTBLUE = new Color(173,216,230);

    public Color LIGHTPINK = new Color(255,182,193);

    public ClientPanelAverage() {
            createAndShowGUI();
    }
    
    private void createAndShowGUI() {
    	JPanel test = new JPanel();
        JLabel avgLabel = new JLabel("<html>Average<br>Value</html>");
        
        avgLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        avgLabel.setSize(85, 60);
        test.setPreferredSize(new Dimension(85, 60));
        test.setBackground(LIGHTBLUE);
        test.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //added text panel where the average value will go.
        JTextPane avgText = new JTextPane();
        avgText.setBorder(BorderFactory.createLineBorder(Color.black));
        avgText.setBackground(LIGHTPINK);
        avgText.setPreferredSize(new Dimension(85, 60));
        avgText.setEditable(false);
        
        add(test);
        test.add(avgLabel);
        add(avgText);
    }
}
