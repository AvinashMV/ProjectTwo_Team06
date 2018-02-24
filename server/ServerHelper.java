package server;
import java.text.NumberFormat;

/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Garv Mathur (#72)
 */

import javax.swing.text.NumberFormatter;

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