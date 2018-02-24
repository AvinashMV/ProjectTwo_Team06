package client;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * ClientWindow class defines the client window basic specifications
 * @author Team 6
 */
public class ClientWindow extends JFrame {
	ClientPanelMain mainPanel;

	public ClientWindow() {
		setTitle("Client (Lab 2, Team 6)");
		add(createMainPanel());
		pack();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centerGUI(this);
		setVisible(true);
	}

	/* createMainPanel function creates the main panel for other sub panel objects
	 * @return : returns the main panel object for other sub panel objects
	 * */
	private ClientPanelMain createMainPanel() {
		mainPanel = new ClientPanelMain();
		return mainPanel;
	}

	/* centerGUI function sets the client window frame object specification
	 * @param frame : main JFrame object of client window frame
	 * */
	private void centerGUI(JFrame frame) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (d.width - w) / 2;
		int y = (d.height - h) / 2;
		frame.setLocation(x, y);
	}
	
	public static void main(String[] args) {
		JFrame client = new ClientWindow();
	}
}
