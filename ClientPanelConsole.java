import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelConsole extends JPanel {
    
    public ClientPanelConsole() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        JPanel test = new JPanel();
        JLabel consoleTxt = new JLabel("CONSOLE");
        //consoleTxt.setHorizontalAlignment(SwingConstants.LEFT);
        test.setPreferredSize(new Dimension(650, 150));
        test.setBorder(BorderFactory.createLineBorder(Color.black));
        test.setBackground(Color.lightGray);
        test.add(consoleTxt);
        add(test);
    }
}
