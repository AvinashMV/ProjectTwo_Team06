//package clientServer.ProjectTwo_Team06;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientWindow extends JFrame {
    ClientPanelMain mainPanel;
    
    public ClientWindow() {
        createAndShowGUI();
    }
    
    public static void main(String[] args) {
        JFrame client = new ClientWindow();
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
    
    private ClientPanelMain createMainPanel() {
        mainPanel = new ClientPanelMain();
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
