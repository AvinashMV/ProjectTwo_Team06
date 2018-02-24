package server;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

/**
 * The ServerConstants class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerConstants {
	public static final Color SLATE_GREY = new Color(200, 200, 200);
	public static final Color PINK = new Color(236, 219, 219);
	public static final Color LIGHT_BLUE = new Color(178, 194, 205);
	public static final String HIGHEST_LABEL = "<html>Highest<br>Value</html>";
	public static final String LOWEST_LABEL = "<html>Lowest<br>Value</html>";
	public static final String FREQUENCY_LABEL = "<html>Frequency<br>(Hz:)</html>";
	public static final Font TEXT_FONT = new Font("SansSerif", Font.BOLD, 17);
	public static final Dimension TEXT_DIMENSION = new Dimension(120, 60);
	public static final Dimension LABEL_DIMENSION = new Dimension(85, 60);
	public static final String SERVER_STATUS_STOP = "Server not Running";
	public static final String START = "Start";
	public static final String STOP = "Stop";
	public static final String START_MESSAGE = "The server has been started. \n";
	public static final String STOP_MESSAGE = "The server has been stopped \n";
	public static final String SERVER_TITLE = "Server (Lab 2, Team 6)";
}
