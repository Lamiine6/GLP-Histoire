package engine.simulation;


import java.awt.Image;

import engine.map.Position;

public class Animation {
	private Image img;
	private Position pos;
	private int x;
	private int y;
	private String orientation;
	private Line ligne;
	
	public Animation(Image img, Position pos, int x, int y, String orientation, Line ligne) {
		this.img = img;
		this.pos = pos;
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.ligne = ligne;
	}
	public Line getLigne() {
		return ligne;
	}
	public void setLigne(Line ligne) {
		this.ligne = ligne;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public void changerAnimation() {
		if (this.orientation.equals("Gauche")) {
			this.pos.setX(this.pos.getPositionX()-this.x);
		}
		if (this.orientation.equals("Droite")) {
			this.pos.setX(this.pos.getPositionX()+this.x);
		}
		if (this.orientation.equals("Haut")) {
			this.pos.setY(this.pos.getPositionY()-this.y);
		}
		if (this.orientation.equals("Bas")) {
			this.pos.setY(this.pos.getPositionY()+this.y);
		}
	}
}