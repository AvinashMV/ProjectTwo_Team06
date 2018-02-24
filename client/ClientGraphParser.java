package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * ClientGraphParser class parse the input data from server and calculates
 * maximum, minimum and average values.
 * 
 * @author Team 6
 */
public class ClientGraphParser {
	int minValue = Integer.MAX_VALUE;
	int maxValue = Integer.MIN_VALUE;
	int average = 0;
	int count = 0;
	int frequency;
	ClientDataManager clientDataManager = ClientDataManager.getInstance();
	private ArrayList<ArrayList<Integer>> dump;
	private ArrayList<ArrayList<Integer>> inputData;
	private ArrayList<Color> colors = new ArrayList<>();

	/*
	 * sets the frequency for receiving data
	 * 
	 * @param frequency : client frequency for receiving data
	 */
	public ClientGraphParser(int frequency) {
		this.frequency = frequency;
	}

	/*
	 * addData function creates the array for graph plot
	 */
	public void addData() {
		dump = clientDataManager.getDump();
		setRandomColors(dump.size());
		ArrayList<Integer> controlValues = new ArrayList<>();
		while (true) {
			dump = clientDataManager.getDump();
			inputData = clientDataManager.getInputData();
			if (dump.get(0).size() == 0) {
				for (int i = 0; i < dump.size(); i++) {
					inputData.get(i).add(0);
				}
			} else {
				for (int i = 0; i < dump.size(); i++) {
					inputData.get(i).add(dump.get(i).get(dump.get(i).size() - 1));
					controlValues.add(dump.get(i).get(dump.get(i).size() - 1));
				}
				calculateControlValues(controlValues);
				setcontrolLabels();
			}
			GraphPlot graphPlot = new GraphPlot(inputData, colors);
			graphPlot.setBackground(Color.WHITE);
			ClientPanelInfo info = ClientDataManager.getInstance().getInfo();
			graphPlot.setPreferredSize(new Dimension(500, 500));
			JPanel panelData = clientDataManager.getPanelData();
			panelData.setLayout(new GridLayout(1, 2));
			panelData.removeAll();
			panelData.add(graphPlot);
			panelData.add(info);
			panelData.repaint();
			panelData.revalidate();
			try {
				Thread.sleep(frequency);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * sets the frequency value
	 * 
	 * @param frequency : client frequency for receiving data
	 */
	private void setcontrolLabels() {
		clientDataManager.getAvgText().setText(String.valueOf(average));
		clientDataManager.getHighTxt().setText(String.valueOf(maxValue));
		clientDataManager.getLowTxt().setText(String.valueOf(minValue));

	}

	/*
	 * calculateControlValues function calculates the minimum, maximum and average
	 * values
	 */
	private void calculateControlValues(ArrayList<Integer> controlValues) {
		average = average * count;
		int sum = 0;
		for (int i = 0; i < controlValues.size(); i++) {
			if (controlValues.get(i) < minValue) {
				minValue = controlValues.get(i);
			}

			if (controlValues.get(i) > maxValue) {
				maxValue = controlValues.get(i);
			}
			sum = sum + controlValues.get(i);
		}
		average = average + sum;
		count = count + controlValues.size();
		average = average / count;

	}

	/*
	 * setRandomColors function assigns colors for each channel
	 * 
	 * @param size : number of channels
	 */
	private void setRandomColors(int size) {
		for (int i = 0; i < size; i++) {
			Random rand = new Random();
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			Color randomColor = new Color(r, g, b);
			colors.add(randomColor);
		}
	}
}
