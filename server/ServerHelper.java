package server;

import java.text.NumberFormat;

import javax.swing.text.NumberFormatter;

/**
 * The MessageHandler class
 * 
 * @author
 * @version 1.0
 */
public class ServerHelper {

	public static NumberFormatter formatter() {
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setValueClass(Long.class);
		numberFormatter.setAllowsInvalid(false);
		numberFormatter.setMinimum(0l);
		return numberFormatter;
	}

}
