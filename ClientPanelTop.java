import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 * @author SER 516, Aman Maheshwari (#66)
 */
public class ClientPanelTop extends JPanel {
    
    public ClientPanelTop() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {    	
    	JPanel test = new JPanel();
        test.setPreferredSize(new Dimension(560, 50));        
    	JButton startStop = new JButton("Start / Stop");
        startStop.setBackground(Color.pink);
        startStop.setBorder(BorderFactory.createLineBorder(Color.black));
        startStop.setPreferredSize(new Dimension(100, 50));
        add(test);
        add(startStop);
    }
}
