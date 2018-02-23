import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ClientGraphParser {
	int frequency;
	ClientDataManager clientDataManager = ClientDataManager.getInstance();
	private ArrayList<ArrayList<Integer>> dump;
	private ArrayList<ArrayList<Integer>> inputData;
	public ClientGraphParser(int frequency) {
		this.frequency = frequency;
		System.out.println("MY frequency is" + frequency);
	}
	
	public void addData() {
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
			
			System.out.println(inputData.get(0).get(inputData.get(0).size() -1) + "Values from input" );
			GraphPlot graphPlot = new GraphPlot(inputData.get(0));
			ClientPanelInfo info = ClientDataManager.getInstance().getInfo();
			graphPlot.setPreferredSize(new Dimension(500,500));
			JPanel panelData = clientDataManager.getPanelData();
			panelData.setLayout(new GridLayout(1, 2));
			panelData.removeAll();
			panelData.add(graphPlot);
			panelData.add(info);
			panelData.repaint();
			panelData.revalidate();
//			
//			ClientPanelGraph
//
//			panelData.add(graphPlot);
//			panelData.repaint();
//			panelData.validate();
			
		
			try {
				Thread.sleep(frequency);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
