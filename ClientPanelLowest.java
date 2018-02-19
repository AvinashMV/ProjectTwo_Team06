import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelLowest extends JPanel {
    
    public ClientPanelLowest() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        JLabel test = new JLabel("LOWEST");
        test.setPreferredSize(new Dimension(200, 70));
        setBackground(Color.lightGray);
        add(test);
    }
}
