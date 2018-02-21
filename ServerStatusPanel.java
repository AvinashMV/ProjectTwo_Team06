//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.JPanel;

public class ServerStatusPanel extends JPanel {
	private BufferedImage image;
	
	public ServerStatusPanel() throws MalformedURLException {
	
		 createLayout();
	     createAndShowGUI();
	}

	private void createAndShowGUI() throws MalformedURLException {
		 URL url = new URL("https://daks2k3a4ib2z.cloudfront.net/5795e690412fc21f2b67d4af/58a0943433b78e327d496a46_loading_5.gif");
	     Icon icon = new ImageIcon(url);
		setBackground(StandardColor.SLATE_GREY);
		JLabel picLabel = new JLabel(icon);
		add(picLabel);
		
	}

	private void createLayout() {
		// TODO Auto-generated method stub
		
	}
}