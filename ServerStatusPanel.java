//package clientServer.ProjectTwo_Team06;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.JPanel;

public class ServerStatusPanel extends JPanel implements Observer {
	private BufferedImage image;
	JLabel picLabel;
	
	public ServerStatusPanel() throws MalformedURLException {
	
		 createLayout();
	     createAndShowGUI();
	}

	private void createAndShowGUI() throws MalformedURLException {
		setBackground(StandardColor.SLATE_GREY);
		picLabel = new JLabel();
		picLabel.setText("Server not Running");
		add(picLabel);
	}
	
	

	private Icon fetchIcon() {
		URL url = null;
		try {
			url = new URL("https://mir-s3-cdn-cf.behance.net/project_modules/source/e2a03d31641415.565a78be188d4.gif");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    return new ImageIcon(url);
	}

	private void createLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		String status = (String) arg;
		if(status.equals("Start")) {
			picLabel.setIcon(fetchIcon());
		}
		else{
			picLabel.setIcon(null);
		}
		
	}
}
