package engine.simulation;
import java.util.ArrayList;

import engine.map.Position;

public class Frontiere {
	private ArrayList<Position> listefrontiere;
	public Frontiere(ArrayList<Position> listefrontiere) {
		this.listefrontiere = listefrontiere;
	}
	public ArrayList<Position> getListefrontiere() {
		return listefrontiere;
	}
	public void setListefrontiere(ArrayList<Position> listefrontiere) {
		this.listefrontiere = listefrontiere;
	}
}
