import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelFrequency extends JPanel {
    
    public ClientPanelFrequency() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        JLabel test = new JLabel("FREQUENCY");
        test.setPreferredSize(new Dimension(200, 70));
        setBackground(Color.yellow);
        add(test);
    }
}
