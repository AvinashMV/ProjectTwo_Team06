package server;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * The ServerWindow class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerWindow extends JFrame {

	/*
	 * @param
	 */
	public static void main(String[] args) {
		MessageHandler.getInstance().setServerSocketMain(new ServerSocketMain());
		ServerWindow serverWindow = new ServerWindow();
		serverWindow.createAndShowGUI();
	}

	/*
	 * 
	 */
	private void createAndShowGUI() {
		setTitle(ServerConstants.SERVER_TITLE);
		add(new ServerPanelMain());
		pack();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centerGUI(this);
		setVisible(true);
	}

	/*
	 * @param frame
	 */
	private void centerGUI(JFrame frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dimension.width - w) / 2;
		int y = (dimension.height - h) / 2;
		frame.setLocation(x, y);
	}
}
