package pooSystem;

public class Tache {
    private Service serv; //  Service reçu par le membre
    private double nbHeures; //  Nombre d'heures de travail
    private int nbMembres; // Nombre de membres presents pour effectuer la tache
    private int prix;	// prix de la tache(coutHoraire service*nbHeures*nbMembres)

    public Tache(Service serv, int nbMembres, double nbHeures) {
        this.serv = serv;
        this.nbMembres = nbMembres;
        this.nbHeures = nbHeures;
        this.prix = (int)nbHeures*nbMembres*serv.getCoutH();
    }
    

	public Service getService(){
    	return this.serv;
    }
    public int getNbMembres(){
    	return this.nbMembres;
    }
    public double getNbHeures(){
    	return this.nbHeures;
    }
    public int getPrix() {
    	return this.prix;
    }
    /** Calcule le prix de la tache
     *  On definit le prix d'une tache par la formule |C * d * p|
     *  ou C est le cout horaire du service demande
     *  ou d est la dur茅e de la tache
     *  ou p est le nombre de personnes realisant la tache
     * 
     *  La valeur obtenue est multipli茅e par le multiplicateur propre à la classe
     *  sociale du membre demandeur : on obtient alors le cout effectif.     */
//     public int      getPrix() {
//        return (
//            (int)(
//                ** Note :
//                 *  Avec des nombres strictement positifs, il n'est pas necessaire
//                 *  d'employer Math.floor() ; un cast en int suffit e supprimer
//                 *  la decimale.
//                 *  
//                 *  Source :
//                 *  stackoverflow.com/questions/2143476/how-to-cast-a-double-to-an-int-in-java-by-rounding-it-down    */
//                this.beneficiaire.getClasse().getDiv() * (
//                    this.serv.getCoutH() * this.nbHeures * this.nbMembres
//                )
//            )
//        );
//    }
}