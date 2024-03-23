package engine.simulation;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireEvenement {
    private List<Evenement> evenementsEnCours;

    public GestionnaireEvenement() {
        this.evenementsEnCours = new ArrayList<>();
    }
    
    public String traiterEvenementsGuerre(int annee, EvenementGuerre eg) {
    	if (annee==eg.getDate().getYear()+eg.getDuree()) {
    		return eg.gagnantGuerre();
    	}
    	else {
    		return "";
    	}
    }
}