import javax.swing.JFrame;


/**
 * Lab 2, Team 6
 * @author SER 516, Gary Morris (#78)
 */
public class ClientWindow extends JFrame {
    
    public ClientWindow() {
        createAndShowGUI();
    }
    
    public static void main(String[] args) {
        JFrame client = new ClientWindow();
    }
    
    private void createAndShowGUI() {
        setTitle("Team 6, Lab 2 - Client");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
