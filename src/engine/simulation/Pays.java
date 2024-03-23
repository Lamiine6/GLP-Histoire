package engine.simulation;

import java.awt.Color;

public class Pays {
	private String nom;
	private int nbr_habitants;
	private double ressources;
	private int[] x;
	private int[] y;
	private Color couleur;
	private Frontiere frontiere;
	public Pays(String nom, int nbr_habitants, double ressources, int[] x, int[] y, Color couleur, Frontiere frontiere) {
		this.nom = nom;
		this.nbr_habitants = nbr_habitants;
		this.ressources = ressources;
		this.x = x;
	    this.y = y;
		this.couleur = couleur;
		this.frontiere = frontiere;
	}
	public Frontiere getFrontiere() {
		return frontiere;
	}
	public String getNom() {
		return this.nom;
	}
	public int getHabitants() {
		return this.nbr_habitants;
	}
	public double getRessources() {
		return this.ressources;
	}
	public int[] getX() {
		return this.x;
	}
	public int[] getY() {
		return this.y;
	}
	public Color getCouleur() {
		return this.couleur;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setHabitants(int nbr_habitants) {
		this.nbr_habitants = nbr_habitants;
	}
	public void setRessources(double ressources) {
		this.ressources = ressources;
	}
	public int obtenirCentre(int[] valeurs) {
        int somme = 0;
        for (int valeur : valeurs) {
            somme += valeur;
        }
        return (int) somme / valeurs.length;
    }
}

