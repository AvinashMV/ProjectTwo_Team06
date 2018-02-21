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
public class ClientPanelLowest extends JPanel {
    
	public Color LIGHTBLUE = new Color(173,216,230);

    public Color LIGHTPINK = new Color(255,182,193);
    
    public ClientPanelLowest() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
    	JPanel test = new JPanel();
        JLabel lowLabel = new JLabel("<html>Lowest<br>Value</html>");
        
        lowLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        lowLabel.setSize(85, 60);
        test.setPreferredSize(new Dimension(85, 60));
        test.setBackground(LIGHTBLUE);
        test.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //added text panel where the lowest value will go.
        JTextPane lowTxt = new JTextPane();
        lowTxt.setBorder(BorderFactory.createLineBorder(Color.black));
        lowTxt.setBackground(LIGHTPINK);
        lowTxt.setPreferredSize(new Dimension(85, 60));
        lowTxt.setEditable(false);
        
        add(test);
        test.add(lowLabel);
        add(lowTxt);
    }
}
