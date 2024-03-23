package engine.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import engine.simulation.Pays;

public class Map {
	private Block[][] blocks;

	private int lineCount;
	private int columnCount;

	public Map(int lineCount, int columnCount) {
		this.lineCount = lineCount;
		this.columnCount = columnCount;

		blocks = new Block[lineCount][columnCount];

		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
			}
		}
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Block getBlock(int line, int column) {
		return blocks[line][column];
	}

	public boolean isOnTop(Block block) {
		int line = block.getLine();
		return line == 0;
	}

	public boolean isOnBottom(Block block) {
		int line = block.getLine();
		return line == lineCount - 1;
	}

	public boolean isOnLeftBorder(Block block) {
		int column = block.getColumn();
		return column == 0;
	}

	public boolean isOnRightBorder(Block block) {
		int column = block.getColumn();
		return column == columnCount - 1;
	}

	public boolean isOnBorder(Block block) {
		return isOnTop(block) || isOnBottom(block) || isOnLeftBorder(block) || isOnRightBorder(block);
	}
	public void EcrireNomPays(Graphics graphics, Pays pays) {
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("SansSerif", Font.PLAIN, 18));
        int xTexte = (pays.obtenirCentre(pays.getX())-20);
        int yTexte = pays.obtenirCentre(pays.getY());
        graphics.drawString(pays.getNom(), xTexte, yTexte);
	}
}