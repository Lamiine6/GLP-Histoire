package engine.simulation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class EvenementGuerre extends Evenement{
	private ArrayList<Pays> pays;
	private int duree;
	
	public EvenementGuerre(String nom, String description, LocalDate date, Boolean estAleatoire, Animation animation, ArrayList<Pays> pays, int duree) {
		super(nom, description, date, estAleatoire, animation);
		this.pays = pays;
		this.duree = duree;
	}
	public ArrayList<Pays> getPays(){
		return this.pays;
	}
	public int getDuree() {
		return this.duree;
	}
	public String gagnantGuerre() {
		Pays pays1 = pays.get(0);
		Pays pays2 = pays.get(1);
		Random aleatoire = new Random();
		if (pays1.getRessources()>pays2.getRessources()) {
			return pays1.getNom();
		}
		else if (pays2.getRessources()>pays1.getRessources()){
			return pays2.getNom();
		}
		else {
			return pays.get(aleatoire.nextInt(2)).getNom();
		}
	}
	public void changementTerritoire(String gagnant) {
		Pays pays1 = pays.get(0);
		Pays pays2 = pays.get(1);
		if (pays1.getNom().equals(gagnant)) {
			
		}
	}
}