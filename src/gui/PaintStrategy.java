package gui;

import java.awt.Color;





import java.awt.*;
import config.SimulationConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.simulation.Animation;
import engine.simulation.Pays;
import engine.data.ListePays;
import java.util.ArrayList;



public class PaintStrategy {
	
	private Animation anim;
	
	public void setAnimation(Animation animation) {
        this.anim = animation;
    }
	public void paint(Map map, Graphics graphics) {
		int blockSize = SimulationConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();
		ListePays lp = new ListePays();
		ArrayList<Pays> listepays = lp.getListePays();
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];
				graphics.setColor(Color.CYAN);
				graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
			}
		}
		for (Pays pays : listepays) {
			graphics.setColor(pays.getCouleur());
			graphics.drawPolygon(pays.getX(), pays.getY(), pays.getX().length);
			graphics.fillPolygon(pays.getX(), pays.getY(), pays.getX().length);
			map.EcrireNomPays(graphics, pays);
			}
		if (anim!=null) {
			graphics.drawImage(this.anim.getImg(), this.anim.getPos().getPositionX(), this.anim.getPos().getPositionY(), null);
			anim.changerAnimation();
			if (anim.getLigne()!=null) {
				graphics.setColor(Color.BLACK);
				Graphics2D graphics2 = (Graphics2D) graphics;
		        graphics2.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
				graphics.drawLine(anim.getLigne().getXdepart(), anim.getLigne().getYdepart()+50, anim.getPos().getPositionX()+150, anim.getPos().getPositionY()+50);
				
			}
		}
	}
	
}