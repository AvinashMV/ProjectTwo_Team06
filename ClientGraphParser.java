import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class ClientGraphParser {
	int frequency;
	ClientDataManager clientDataManager = ClientDataManager.getInstance();
	private ArrayList<ArrayList<Integer>> dump;
	private ArrayList<ArrayList<Integer>> inputData;
	private ArrayList<Color> colors = new ArrayList<>();
	public ClientGraphParser(int frequency) {
		this.frequency = frequency;
		System.out.println("MY frequency is" + frequency);
	}
	
	public void addData() {
		dump = clientDataManager.getDump();
		setRandomColors(dump.size());
		while(true) {
			dump = clientDataManager.getDump();
			
			inputData = clientDataManager.getInputData();
			if(dump.get(0).size() == 0) {
				for(int i=0; i < dump.size(); i++) {
					inputData.get(i).add(0);
				}
			}
			else {
				for(int i=0; i < dump.size(); i++) {
					inputData.get(i).add(dump.get(i).get(dump.get(i).size() -1));
				}
			}
			
			GraphPlot graphPlot = new GraphPlot(inputData,colors);
			ClientPanelInfo info = ClientDataManager.getInstance().getInfo();
			graphPlot.setPreferredSize(new Dimension(500,500));
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void setRandomColors(int size) {
		for(int i=0; i < size; i++ ) {
			colors.add(generateRandomColor());
		}
		
	}

	private Color generateRandomColor() {
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		return new Color(r, g, b);
}
}
