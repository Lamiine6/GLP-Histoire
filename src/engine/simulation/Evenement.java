package engine.simulation;

//import gui.Animation;
import java.time.*;

public class Evenement {
	private String nom;
	private String description;
	private LocalDate date;
	private Boolean estAleatoire;
	private Animation animation;
	public Evenement(String nom, String description, LocalDate date, Boolean estAleatoire, Animation anim) {
		this.nom = nom;
		this.description = description;
		this.date = date;
		this.estAleatoire = estAleatoire;
		this.animation = anim;
	}
	public String getNom() {
		return this.nom;
	}
	public String getDescription() {
		return this.description;
	}
	public LocalDate getDate() {
		return this.date;
	}
	public Boolean getEstAleatoire() {
		return this.estAleatoire;
	}
	
	public Animation getAnimation() {
		return animation;
	}
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	public String toString() {
		return "L'événement "+ this.nom + " s'est déroulé en "+this.date.toString()+". Voici une description de l'événement :\n"+this.description;
	}
}