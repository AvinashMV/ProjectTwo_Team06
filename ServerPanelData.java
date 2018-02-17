import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ServerPanelData extends JPanel {
    
    public ServerPanelData() {
        createAndShowGUI();
    }
    
    private void createAndShowGUI() {
        JLabel test = new JLabel("DATA");
        test.setPreferredSize(new Dimension(600, 400));
        setBackground(Color.white);
        add(test);
    }
}
