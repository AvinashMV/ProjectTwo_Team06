import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientPanelConsole extends JPanel {
    
    public ClientPanelConsole() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        JLabel test = new JLabel("CONSOLE");
        test.setPreferredSize(new Dimension(600, 150));
        setBackground(Color.blue);
        add(test);
    }
}
