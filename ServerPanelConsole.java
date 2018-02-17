import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Rishab Mantri (#69)
 */
public class ServerPanelConsole extends JPanel {
    
    public ServerPanelConsole() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        JLabel test = new JLabel("CONSOLE");
        test.setPreferredSize(new Dimension(600, 150));
        setBackground(Color.blue);
        add(test);
    }
}
