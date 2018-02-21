import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelTop extends JPanel {
    
    public ClientPanelTop() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        
    	setBackground(StandardColor.SLATE_GREY);
    	JPanel test = new JPanel();
        test.setPreferredSize(new Dimension(480, 50));
        test.setBackground(StandardColor.SLATE_GREY);
        
        JButton startStop = new JButton("Start / Stop");
        startStop.setBackground(Color.pink);
        startStop.setBounds(580, 10, 190, 30);
        startStop.setBorder(BorderFactory.createLineBorder(Color.black));
        startStop.setPreferredSize(new Dimension(100, 50));
        add(test);
        add(startStop);
    }
}
