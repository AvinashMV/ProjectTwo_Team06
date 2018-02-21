import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 */
public class ClientPanelHighest extends JPanel {
    
	public Color LIGHTBLUE = new Color(173,216,230);

    public Color LIGHTPINK = new Color(255,182,193);
    
    public ClientPanelHighest() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        JPanel test = new JPanel();
        
        JLabel highLabel = new JLabel("<html>Highest<br>Value</html>");
        highLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        highLabel.setSize(85, 60);
        
        test.setPreferredSize(new Dimension(85, 60));
        test.setBounds(580, 10, 190, 30);
        test.setBackground(LIGHTPINK);
        test.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //added text panel where the highest value will go.
        JTextPane highTxt = new JTextPane();
        highTxt.setBorder(BorderFactory.createLineBorder(Color.black));
        highTxt.setBackground(LIGHTBLUE);
        highTxt.setPreferredSize(new Dimension(85, 60));
        highTxt.setEditable(false);
        
        add(test);
        test.add(highLabel);
        add(highTxt);
    }
}
