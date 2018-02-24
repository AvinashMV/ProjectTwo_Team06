package client;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

/**
 * GraphPlot class plots the data stream received from server on Graph component
 * 
 * @author Team 6
 * 
 */
public class GraphPlot extends JPanel {
	ArrayList<ArrayList<Integer>> serverData = new ArrayList<>();
	final int PAD = 0;
	ArrayList<Color> colors;

	/*
	 * @param inputData : Data received from server
	 * 
	 * @param colors : channel colors for graph plotting Function paintComponent
	 * initializing the graph attributes on 'baseGraph'
	 */
	GraphPlot(ArrayList<ArrayList<Integer>> inputData, ArrayList<Color> colors) {
		serverData.addAll(inputData);
		this.colors = colors;
	}

	/*
	 * @param baseGraph : Graphics component Function paintComponent
	 * initializing the graph attributes on 'baseGraph'
	 */
	protected void paintComponent(Graphics baseGraph) {
		super.paintComponent(baseGraph);
		Graphics2D graph = (Graphics2D) baseGraph;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int height = getHeight();
		graph.draw(new Line2D.Double(PAD, PAD, PAD, height - PAD));
		graph.draw(new Line2D.Double(PAD, height - PAD, width - PAD, height - PAD));
		Font font = graph.getFont();
		FontRenderContext fontContext = graph.getFontRenderContext();
		LineMetrics lnMetrics = font.getLineMetrics("0", fontContext);
		float sh = lnMetrics.getAscent() + lnMetrics.getDescent();
		float sy = PAD + (height - 2 * PAD) + lnMetrics.getAscent();
		graph.drawString("", PAD / 2, sy);
		sy += sh;
		sy = height - PAD + (PAD - sh) / 2 + lnMetrics.getAscent();
		graph.drawString("", width / 2, sy);

		for (int i = 0; i < serverData.size(); i++) {
			paintData(i, graph);
		}
	}

	/*
	 * @param i : index of element in server data
	 * 
	 * @param graph : Graphics component Function paintData plots the data
	 * elements on Graph
	 */
	private void paintData(int i, Graphics2D graph) {
		ArrayList<Integer> channelData = serverData.get(i);
		int width = getWidth();
		int height = getHeight();
		double xInc = (double) (width - 2 * PAD) / (channelData.size() - 1);
		double scale = (double) (height - 2 * PAD) / checkMaxDataPoint(channelData);
		graph.setPaint(colors.get(i));
		for (int index = 0; index < channelData.size() - 1; index++) {
			double x1 = PAD + index * xInc;
			double y1 = height - PAD - scale * channelData.get(index);
			double x2 = PAD + (index + 1) * xInc;
			double y2 = height - PAD - scale * channelData.get(index + 1);
			graph.draw(new Line2D.Double(x1, y1, x2, y2));
		}
		graph.setPaint(Color.green.darker().darker().darker().darker());
		for (int index = 0; index < channelData.size(); index++) {
			double x = PAD + index * xInc;
			double y = height - PAD - scale * channelData.get(index);
			graph.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));
		}
	}

	/*
	 * @param data : channel data
	 * 
	 * @return max : maximum data element Function checkMaxDataPoint calculates
	 * the maximum data point from data stream
	 */
	private int checkMaxDataPoint(ArrayList<Integer> data) {
		int max = -Integer.MAX_VALUE;
		for (int index = 0; index < data.size(); index++) {
			if (data.get(index) > max)
				max = data.get(index);
		}
		return max;
	}
}
