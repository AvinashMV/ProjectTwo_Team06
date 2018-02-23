import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

/**
 * Lab 2, Team 6
 * 
 * @author SER 516, Garv Mathur (#72)
 */

public class ClientDataManager {
	private static volatile ClientDataManager clientDataManager;
	private static Object mutex = new Object();
	private ArrayList<ArrayList<Integer>> dump;
	private ArrayList<ArrayList<Integer>> inputData;
	private JTextPane freqText;
	ClientPanelData panelData;
	ClientPanelInfo info;
	JTextPane highTxt;
	JTextPane lowTxt;
	JTextPane avgText;

	public JTextPane getHighTxt() {
		return highTxt;
	}

	public void setHighTxt(JTextPane highTxt) {
		this.highTxt = highTxt;
	}

	public JTextPane getLowTxt() {
		return lowTxt;
	}

	public void setLowTxt(JTextPane lowTxt) {
		this.lowTxt = lowTxt;
	}

	public JTextPane getAvgText() {
		return avgText;
	}

	public void setAvgText(JTextPane avgText) {
		this.avgText = avgText;
	}

	public ClientPanelInfo getInfo() {
		return info;
	}

	public void setInfo(ClientPanelInfo info) {
		this.info = info;
	}

	public ClientPanelData getPanelData() {
		return panelData;
	}

	public void setPanelData(ClientPanelData panelData) {
		this.panelData = panelData;
	}

	public JTextPane getFreqText() {
		return freqText;
	}

	public void setFreqText(JTextPane freqText) {
		this.freqText = freqText;
	}

	public ArrayList<ArrayList<Integer>> getDump() {
		return dump;
	}

	public void setDump(ArrayList<ArrayList<Integer>> dump) {
		this.dump = dump;
	}

	int max = 0;
	int min = 0;
	int average = 0;
	JComboBox<String> channelDD;

	public JComboBox<String> getChannelDD() {
		return channelDD;
	}

	public void setChannelDD(JComboBox<String> channelDD) {
		this.channelDD = channelDD;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

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

	public ArrayList<ArrayList<Integer>> getInputData() {
		return inputData;
	}

	public void setInputData(ArrayList<ArrayList<Integer>> inputData) {
		this.inputData = inputData;
	}
}
