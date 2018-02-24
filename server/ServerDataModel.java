package server;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The ServerDataModel class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerDataModel {

	private static volatile ServerDataModel serverDataManager;
	private static Object mutex = new Object();
	private static int channels = 1;
	private static long highestValue = 1024;
	private static long lowestValue = 0;

	private ServerDataModel() {
	}

	public static ServerDataModel getInstance() {
		ServerDataModel result = serverDataManager;
		if (result == null) {
			synchronized (mutex) {
				result = serverDataManager;
				if (result == null)
					result = new ServerDataModel();
				serverDataManager = result;
			}
		}
		return result;
	}

	public static int getChannels() {
		return channels;
	}

	public static void setChannels(int channels) {
		ServerDataModel.channels = channels;
	}

	public static long getHighestValue() {
		return highestValue;
	}

	public static void setHighestValue(long highestValue) {
		ServerDataModel.highestValue = highestValue;
	}

	public static long getLowestValue() {
		return lowestValue;
	}

	public static void setLowestValue(long lowestValue) {
		ServerDataModel.lowestValue = lowestValue;
	}

	public static String generateNumbers() {
		ArrayList<Long> list = new ArrayList<>();
		for (int i = 0; i < ServerDataModel.channels; i++) {
			long randomNum = ThreadLocalRandom.current().nextLong(lowestValue, highestValue + 1);
			list.add(randomNum);
		}
		StringBuilder data = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			data.append(String.valueOf(list.get(i)));
			data.append(",");
		}
		String result = data.toString();
		result = result.substring(0, result.length() - ",".length());
		return result;
	}
}
