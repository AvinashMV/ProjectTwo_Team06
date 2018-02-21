import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelGraph extends JPanel {
    
	public Color LIGHTPINK = new Color(255,182,193);
	
    public ClientPanelGraph() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
    	JPanel test = new JPanel();
        test.setPreferredSize(new Dimension(480, 350));
        test.setBorder(BorderFactory.createLineBorder(Color.black));
        test.setBackground(LIGHTPINK);
        add(test);
    }
}
