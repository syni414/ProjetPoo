package pooSystem;

import java.util.ArrayList;


public class Reseau {
    private String nomRes; // Nom du reseau
    private Administrateur admin; // Administrateur du reseau
    private ArrayList<Membre> lMembres; // Liste des membres du reseau
    private ArrayList<Tache> lTaches;  // Liste des taches, les membres peuvent en demander 
    private ArrayList<TacheConfirmee> lTachesConf;  //Liste Taches Confirmées

    public final static int soldeInitial = 200; // On choisit d'offrir 200 jetons au chaque nouveau Membre.

    public Reseau(String nomRes)  { 
        this.nomRes = nomRes;
        this.lMembres = new ArrayList<Membre>();
        this.admin = null;
        this.lTaches = new ArrayList<Tache>();
        this.lTachesConf = new ArrayList<TacheConfirmee>();
    }
    //méthodes
    			//les gets
    public String getNom(){
    	return this.nomRes;
    }
    public Administrateur getAdmin(){
    	return this.admin;
    }
    public ArrayList<Membre> getMembres(){
    	return this.lMembres;
    }
    public ArrayList<Tache> getListeTache(){
    	return lTaches;
    }
    public ArrayList<TacheConfirmee> getListeTacheConfirmee(){
    	return lTachesConf;
    }
    			//les affiches
    public void afficherLesMembres() {
    	for(Membre membre: lMembres) {
    		System.out.println(membre);
    	}
    }
    public void afficherLesMembresAvecInformations() {
    	System.out.println("-----Information des Membres à jour:-----");
    	for(Membre membre: lMembres) {
    		System.out.println(membre +" "+ membre.getClasse()+" "+ membre.getJeton());
    	} 
    	System.out.println("----vous ête au bout de la liste----");
    }
    public void afficherLesTaches() {
    	for(Tache tache: lTaches) {
    		System.out.println(tache.toString());
    	}
    }
    public void afficherLesTachesConfirmees() {
     	for(TacheConfirmee tacheConf: lTachesConf) {
    		System.out.println(tacheConf.toString());
    	}
    }
    			//ajout des taches/taches confirmees
    public void ajoutTache(Tache tache) { // Ajout de tache
    	this.lTaches.add(tache);
    }
    public void ajoutTacheConf(TacheConfirmee tacheConf) { // Ajout de tache confirmee
    	this.lTachesConf.add(tacheConf);
    }
    
    			//set les parametres
    public void	setAdmin(Administrateur admi){
    	this.admin = admi;
    }

    			//actions sur les membres
    public void ajoutMembre(Membre m) { // Ajout de membres
    	this.lMembres.add(m);
    }
    
    public void retraitMembre(Membre m) {
    	// retrait de membres
    	lMembres.remove(m);
    }

    //  Remplace un membre par un autre 
    public void repMembre(String pseudo, Membre m) throws Exception {
        try {
            int index = findMembre(pseudo);
            this.lMembres.remove(index);
            this.lMembres.add(index, m);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //  Renvoie l'index d'un membre dans une liste de membres à partir de son pseudo
    public int findMembre(String pseudo) throws Exception {
        int i           = 0;
        boolean flag    = false;    //  Faux tant que le membre n'est pas trouvé

        while(!flag && i < lMembres.size()) {
            flag = (pseudo == lMembres.get(i).toString());
            i++;
        }

        if(flag) {
            return (i - 1);
        } else {
            throw new Exception("ERROR: le membre " + pseudo + " n'appartient pas au réseau!");
        }
    }

    //  Renvoie le membre au pseudo paramétré
    public Membre getMembre(String pseudo) {
    	Membre membre = new Membre();
    	for (int i=0;i< lMembres.size();i++) {
			if (lMembres.get(i).getNom().equals(pseudo)) {
    			membre = lMembres.get(i);
    		}
    	}
		return membre;
    } 
