import java.awt.Color;
import java.awt.Dimension;
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
        JLabel test = new JLabel("TOP");
        test.setPreferredSize(new Dimension(600, 50));
        setBackground(Color.pink);
        add(test);
    }
}