package pooSystem;

public class ClasseSociale {
    protected double diviseur; // Sera multiplié au coût de la tâche

    public ClasseSociale(double diviseur) {
        this.diviseur = diviseur;
    }

    public double getDiv() {
    	return this.diviseur;
    }
    	
}