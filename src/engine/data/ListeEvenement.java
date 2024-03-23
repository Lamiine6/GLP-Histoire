package engine.data;
import engine.map.Position;


import engine.simulation.Animation;
import engine.simulation.Evenement;
import engine.simulation.EvenementGuerre;
import engine.simulation.Line;
import engine.simulation.Pays;

import javax.swing.JLabel;
import java.util.*;
import java.awt.Toolkit;
import java.time.*;


public class ListeEvenement {
	private HashMap<Integer, Evenement> listeevenement;
	public ListeEvenement() {
		ListePays lp = new ListePays();
		ArrayList<Pays> listepays = lp.getListePays();
		this.listeevenement = new HashMap<>();
		Animation animSeminara = new Animation(Toolkit.getDefaultToolkit().getImage("src/images/guerre.png"), new Position(835, 535, 1), 0, 0, "", null);
		Line ligne1 = new Line(809, 700);
		Animation bateau = new Animation(Toolkit.getDefaultToolkit().getImage("src/images/bateau.png"), new Position(809, 700, 1), 30, 0, "Gauche", ligne1);
		Evenement decouverteAmerique = new Evenement("Découverte de l'Amérique", "L'événement \"Découverte de l'Amérique\" est un moment historique majeur, lorsque Christophe Colomb, navigateur génois au service des Rois Catholiques espagnols, a atteint les Amériques.", LocalDate.of(1492, 10, 12), false, bateau);
		listeevenement.put(1492, decouverteAmerique);
		ArrayList<Pays> paysSeminara = new ArrayList<>();
		paysSeminara.add(lp.getPays("France"));
		paysSeminara.add(lp.getPays("Espagne"));
		EvenementGuerre batailleSeminara = new EvenementGuerre("Bataille de Seminara", "Bataille entre la France et l'Espagne", LocalDate.of(1495, 6, 28), false, animSeminara, paysSeminara, 3);
		listeevenement.put(1495, batailleSeminara);
		
	}
	public HashMap<Integer, Evenement> getListeEvenement(){
		return this.listeevenement;
	}
	public Boolean contientEvenement(int time, JLabel second) {
		return (this.listeevenement.containsKey(time) && ((Integer.valueOf(second.getText())-1)%2==0));
	}
}