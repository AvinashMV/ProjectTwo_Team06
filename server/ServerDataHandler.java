package server;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFormattedTextField;

public class ServerDataHandler {

	private static volatile ServerDataHandler serverDataHandler;
	private static Object mutex = new Object();
	JFormattedTextField frequency;
	JFormattedTextField lowText;
	JFormattedTextField highText;
	public JFormattedTextField getFrequency() {
		return frequency;
	}

	public void setFrequency(JFormattedTextField frequency) {
		this.frequency = frequency;
	}

	public JFormattedTextField getLowText() {
		return lowText;
	}

	public void setLowText(JFormattedTextField lowText) {
		this.lowText = lowText;
	}

	public JFormattedTextField getHighTxt() {
		return highTxt;
	}

	public void setHighTxt(JFormattedTextField highTxt) {
		this.highTxt = highTxt;
	}

	JFormattedTextField highTxt;

	private ServerDataHandler() {
	}

	public static ServerDataHandler getInstance() {
		ServerDataHandler result = serverDataHandler;
		if (result == null) {
			synchronized (mutex) {
				result = serverDataHandler;
				if (result == null)
					result = new ServerDataHandler();
				serverDataHandler = result;
			}
		}
		return result;
	}

}

