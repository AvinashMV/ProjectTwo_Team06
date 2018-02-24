package server;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The ServerControlPanel class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerDataManager {

	private static volatile ServerDataManager serverDataManager;
	private static Object mutex = new Object();
	private static int channels = 3;
	private static long highestValue = 1024;
	private static long lowestValue = 0;

	private ServerDataManager() {
	}

	public static int getChannels() {
		return channels;
	}

	public static void setChannels(int channels) {
		ServerDataManager.channels = channels;
	}

	public static long getHighestValue() {
		return highestValue;
	}

	public static void setHighestValue(long highestValue) {
		ServerDataManager.highestValue = highestValue;
	}

	public static long getLowestValue() {
		return lowestValue;
	}

	public static void setLowestValue(long lowestValue) {
		ServerDataManager.lowestValue = lowestValue;
	}

	/*
	 * Singleton instance creation method
	 * @return result
	 */
	public static ServerDataManager getInstance() {
		ServerDataManager result = serverDataManager;
		if (result == null) {
			synchronized (mutex) {
				result = serverDataManager;
				if (result == null)
					result = new ServerDataManager();
				serverDataManager = result;
			}
		}
		return result;
	}

	/*Singleton random number generation method
	 * @result result
	 */
	public static String generateNumbers() {
		ArrayList<Long> list = new ArrayList<>();
		for (int i = 0; i < ServerDataManager.channels; i++) {
			long randomNum = ThreadLocalRandom.current().nextLong(lowestValue, highestValue + 1);
			list.add(randomNum);
		}
		StringBuilder data = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			data.append(String.valueOf(list.get(i)));
			data.append(ServerConstants.COMMA);
		}
		String result = data.toString();
		result = result.substring(0, result.length() - 1);
		return result;
	}
}
