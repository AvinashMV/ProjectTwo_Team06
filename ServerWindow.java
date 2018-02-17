import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ServerWindow extends JFrame {
    ServerPanelMain mainPanel;
    
    public ServerWindow() {
        createAndShowGUI();
    }
    
    public static void main(String[] args) {
        JFrame client = new ServerWindow();
    }
    
    private void createAndShowGUI() {
        setTitle("Client (Lab 2, Team 6)");
        add(createMainPanel());
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centerGUI(this);
        setVisible(true);
    }
    
    private ServerPanelMain createMainPanel() {
        mainPanel = new ServerPanelMain();
        return mainPanel;
    }
    
    private void centerGUI(JFrame frame) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (d.width - w) / 2;
        int y = (d.height - h) / 2;
        frame.setLocation(x, y);
    }
}
