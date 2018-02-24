package client;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

/**
 * Class ClientDataManager is singleton instance to handle the data manipulation
 * 
 * @author Team 6
 *
 */
public class ClientDataManager {
	private static volatile ClientDataManager clientDataManager;
	private static Object mutex = new Object();
	private ArrayList<ArrayList<Integer>> dump;
	private ArrayList<ArrayList<Integer>> inputData;
	private JTextPane freqText;
	private ClientPanelData panelData;
	private ClientPanelInfo info;
	private JTextPane highTxt;
	private JTextPane lowTxt;
	private JTextPane avgText;
	private int max = 0;
	private int min = 0;
	private int average = 0;
	JComboBox<String> channelDD;

	/*
	 * getHighTxt function returns reference for highest value text
	 * 
	 * @return : highest value text object
	 */
	public JTextPane getHighTxt() {
		return highTxt;
	}

	/*
	 * getHighTxt function sets value for highest value text
	 * 
	 * @param highTxt : highest value text object
	 */
	public void setHighTxt(JTextPane highTxt) {
		this.highTxt = highTxt;
	}

	/*
	 * getLowTxt function returns reference for lowest value text
	 * 
	 * @return : lowest value text object
	 */
	public JTextPane getLowTxt() {
		return lowTxt;
	}

	/*
	 * setLowTxt function sets value for lowest value text
	 * 
	 * @param lowTxt : highest value text object
	 */
	public void setLowTxt(JTextPane lowTxt) {
		this.lowTxt = lowTxt;
	}

	/*
	 * getAvgText function returns reference for average value text
	 * 
	 * @return : returns the average value text object
	 */
	public JTextPane getAvgText() {
		return avgText;
	}

	/*
	 * setAvgText function sets value for average value text
	 * 
	 * @param avgText : average value text object
	 */
	public void setAvgText(JTextPane avgText) {
		this.avgText = avgText;
	}

	/*
	 * getInfo function returns reference for info object
	 * 
	 * @return : returns the info object
	 */
	public ClientPanelInfo getInfo() {
		return info;
	}

	/*
	 * setInfo function sets value for info object
	 * 
	 * @param info : info object
	 */
	public void setInfo(ClientPanelInfo info) {
		this.info = info;
	}

	/*
	 * getInfo function returns reference for info object
	 * 
	 * @return : returns the info object
	 */
	public ClientPanelData getPanelData() {
		return panelData;
	}

	/*
	 * setPanelData function sets value for data panel object
	 * 
	 * @param panelData : panel data object
	 */
	public void setPanelData(ClientPanelData panelData) {
		this.panelData = panelData;
	}

	/*
	 * getFreqText function returns frequency text object
	 * 
	 * @return : returns frequency text object
	 */
	public JTextPane getFreqText() {
		return freqText;
	}

	/*
	 * setFreqText function sets value for info object
	 * 
	 * @param freqText : frequency text object
	 */
	public void setFreqText(JTextPane freqText) {
		this.freqText = freqText;
	}

	/*
	 * getDump function returns reference for server data dump object
	 * 
	 * @return : returns the server data dump object
	 */
	public ArrayList<ArrayList<Integer>> getDump() {
		return dump;
	}

	/*
	 * setFreqText function sets value for server data dump object
	 * 
	 * @param dump : server data dump object
	 */
	public void setDump(ArrayList<ArrayList<Integer>> dump) {
		this.dump = dump;
	}

	/*
	 * getChannelDD function returns reference for channel component
	 * 
	 * @return : returns the channel component
	 */
	public JComboBox<String> getChannelDD() {
		return channelDD;
	}

	/*
	 * setChannelDD function sets value for info object
	 * 
	 * @param channelDD : info object
	 */
	public void setChannelDD(JComboBox<String> channelDD) {
		this.channelDD = channelDD;
	}

	/*
	 * getMax function returns reference for infogetMax object
	 * 
	 * @return : returns the info object
	 */
	public int getMax() {
		return max;
	}

	/*
	 * setMax function sets maximum value
	 * 
	 * @param max : maximum value
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/*
	 * getMin function returns minimum value
	 * 
	 * @return : returns minimum value
	 */
	public int getMin() {
		return min;
	}

	/*
	 * setMin function sets minimum value
	 * 
	 * @param min : minimum value
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/*
	 * getAverage function returns average value
	 * 
	 * @return : returns the average value
	 */
	public int getAverage() {
		return average;
	}

	/*
	 * setAverage function sets average value
	 * 
	 * @param min : average value
	 */
	public void setAverage(int average) {
		this.average = average;
	}

	/*
	 * getInstance function returns single reference object
	 * 
	 * @return : returns the single reference object
	 */
	public static ClientDataManager getInstance() {
		ClientDataManager result = clientDataManager;
		if (result == null) {
			synchronized (mutex) {
				result = clientDataManager;
				if (result == null)
					result = new ClientDataManager();
				clientDataManager = result;
			}
		}
		return result;
	}

	/*
	 * getInputData function returns input data from server
	 * 
	 * @return : returns the input object
	 */
	public ArrayList<ArrayList<Integer>> getInputData() {
		return inputData;
	}

	/*
	 * setAverage function sets input data from server
	 * 
	 * @param inputData : input data object
	 */
	public void setInputData(ArrayList<ArrayList<Integer>> inputData) {
		this.inputData = inputData;
	}

	/*
	 * initializeArray function initializes input data with same channel numbers as
	 * dump data
	 */
	public void initializeArray() {
		String channel = (String) ClientDataManager.getInstance().getChannelDD().getSelectedItem();
		dump = new ArrayList<>();
		inputData = new ArrayList<>();

		for (int i = 0; i < Integer.parseInt(channel); i++) {
			dump.add(new ArrayList<>());
		}

		for (int i = 0; i < Integer.parseInt(channel); i++) {
			inputData.add(new ArrayList<>());
		}

	}
}
