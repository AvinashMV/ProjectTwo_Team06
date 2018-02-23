package server;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * 
 * @author
 * @version 1.0
 */
public class ServerMainWindow extends JFrame {

	private ServerControlsPanel serverControlPanel;
	private ServerConsolePanel serverConsolePanel;
	private ServerStatusPanel serverStatusPanel;
	private ServerTopPanel serverTopPanel;
	private JPanel dataPanel;
	JPanel bodyPanel;

	public ServerMainWindow() {
		serverConsolePanel = new ServerConsolePanel();
		MessageHandler.getInstance().setServerPanelConsole(serverConsolePanel);
		serverControlPanel = new ServerControlsPanel();
		serverStatusPanel = new ServerStatusPanel();
		MessageHandler.getInstance().setServerStatusPanel(serverStatusPanel);
		serverTopPanel = new ServerTopPanel();
		bodyPanel = new JPanel();
		dataPanel = new JPanel();
		dataPanel.setLayout(new GridLayout(1, 2));
	}

	private void createServerWindow() {
		serverControlPanel.createAndShowGUI();
		serverStatusPanel.createAndShowGUI();
		serverConsolePanel.createAndShowGUI();
		serverTopPanel.createAndShowGUI();
		Border line = BorderFactory.createLineBorder(ServerConstants.LIGHT_BLUE, 5);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		bodyPanel.setBorder(BorderFactory.createCompoundBorder(line, loweredbevel));
		dataPanel.add(serverStatusPanel);
		dataPanel.add(serverControlPanel);
		serverTopPanel.setPreferredSize(new Dimension(800, 50));
		dataPanel.setPreferredSize(new Dimension(800, 400));
		serverConsolePanel.setPreferredSize(new Dimension(800, 150));
		bodyPanel.add(serverTopPanel);
		bodyPanel.add(dataPanel);
		bodyPanel.add(serverConsolePanel);
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		this.setTitle(ServerConstants.SERVER_TITLE);
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.centerGUI(this);
		this.setVisible(true);
		this.add(bodyPanel);
	}

	private void centerGUI(JFrame frame) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (d.width - w) / 2;
		int y = (d.height - h) / 2;
		frame.setLocation(x, y);
		frame.setSize(800, 700);
	}

	public static void main(String[] args) {
		ServerMainWindow mainWindow = new ServerMainWindow();
		mainWindow.createServerWindow();
	}
}
