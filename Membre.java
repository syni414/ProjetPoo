package pooSystem;

import java.util.ArrayList;

public class Membre {
	protected String nomM; // Nom du membre
	protected ClasseSociale classeSoc; // Classe sociale du membre
	protected int nbJetons; // nombre de jetons du membre
	protected Reseau res; // Reseau auquel appartient le membre
	protected ArrayList<Service> lServices; // Liste de services proposée par le membre

	public Membre(String nomM, ClasseSociale classeSoc) { //Lors de sa création, on attribue un nom et un nombre de jetons au membre 
		this.nomM = nomM;
		this.classeSoc = classeSoc;
		this.nbJetons = Reseau.soldeInitial;
		this.res = null;
		this.lServices = new ArrayList<Service>();
	    }
	
	public Membre() {
		// TODO Auto-generated constructor stub
	}

	// méthodes
				// les gets:
	public String getNom(){
		return this.nomM;
	}
	public ClasseSociale getClasse(){
		return this.classeSoc;
	}
	public int getJeton(){
		return this.nbJetons;
	}
	public ArrayList<Service> getServiceList(){
		return this.lServices;
	}
	public Reseau getReseau(){
		return this.res;
	}
	public String toString() {
		return nomM;
	}
	
	//actions sur les Soldes
	public void debitSolde(int valeur){
		this.nbJetons -=  valeur;
	}
    public void creditSolde(int valeur) {
        this.nbJetons += valeur;
    }
    // lui associer un réseau
    public void	setRes(Reseau res){
    	this.res = res;
    }
    // actions sur les services
    public void ajoutService(Service serv) { // Un membre peut ajouter des services à sa liste de services
        this.lServices.add(serv);
    }
 
    public void ajoutListeServices(ArrayList<Service> listServ) { // ajouter une liste de services pour faciliter le procédure
        for(Service serv : listServ) {  
    	this.ajoutService(serv);
        }
    }
    // afficher la liste de services proposées du membre
    public void afficheService() {
    	for(Service serv : lServices) { 
    		System.out.println(serv);
    	}
    }
    
    //demande la validation d'une tache à l'administeateur 
    public void demanderValid(Tache t) throws Exception { // Un membre peut demander à l'administateur de valider une tâche
    	this.res.getAdmin().valider(t,this);
    }
}
