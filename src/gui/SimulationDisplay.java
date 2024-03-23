package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import engine.map.Map;
import engine.simulation.Animation;


public class SimulationDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public SimulationDisplay(Map map) {
		this.map = map;
	}
	public void repaint(Animation anim) {
        if (paintStrategy!=null) {
        	paintStrategy.setAnimation(anim);
        }
        super.repaint(); 
    }

    @Override
    public void repaint() {
        super.repaint();
        if (paintStrategy!=null) {
        	paintStrategy.setAnimation(null);
        }
    }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(map, g);

	}
}
