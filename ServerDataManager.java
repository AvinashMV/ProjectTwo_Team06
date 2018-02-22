import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.sun.xml.internal.ws.util.StringUtils;

public class ServerDataManager {
	
	private static volatile ServerDataManager serverDataManager;
	private static Object mutex = new Object();
	private static int channels;
	private static long highestValue;
	private static long lowestValue;
	
	
	
	private ServerDataManager() {
	}

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

	public static String  generateNumbers() {
		ArrayList<Long> list = new ArrayList<>();
		for(int i=0; i <ServerDataManager.channels; i++) {
			long randomNum = ThreadLocalRandom.current().nextLong(lowestValue, highestValue + 1);
			list.add(randomNum);
		}
		StringBuilder data = new StringBuilder();
		for(int i=0; i < list.size(); i++){
			 data.append(String.valueOf(list.get(i)));
			 data.append(","); 
		 }
		String result = data.toString();
		result = result.substring(0, result.length() - ",".length());
		return result;
	}
	
	
	
	public static void main(String args[]) {
		ServerDataManager s = ServerDataManager.getInstance();
		s.setChannels(2);
		s.setHighestValue(2000);
		s.setLowestValue(1998);
		System.out.println(s.generateNumbers());
		System.out.println(s.generateNumbers());
		ServerDataManager d = ServerDataManager.getInstance();
		System.out.print(d.generateNumbers());
	}
	
	

}
