package pooSystem;

import java.util.ArrayList;

public final class Administrateur extends Membre {
    public Administrateur(String nomM) {
        super(nomM, new ClasseNormale()); // L'administrateur est un membre de classe normale
    }

    public void creationReseau(String nom) { // Creation du reseau
        this.res = new Reseau(nom);
        res.ajoutMembre(this); // Ajout de l'administateur comme membre du reseau
        this.res.setAdmin(this); //	Mise en fonction de l'administrateur dans le reseau
    }


    public void creationAjoutMembre(String nom, ClasseSociale classeSociale) {    //  Creation et ajout d'un nouveau membre dans le reseau
        Membre membre = new Membre(nom, classeSociale);
    	res.ajoutMembre(membre);  
    	membre.setRes(this.getReseau());
    }
    
    // validation de la tache demandée par utilisateur
    public void	valider(Tache t, Membre beneficiaire) throws Exception {
        try {
            ArrayList<Membre> lPart = new ArrayList<Membre>(); 
            lPart =	trouverParticipants(t.getNbMembres(), t.getService(), this.res,beneficiaire);
            //	Si il y a assez de membres qui proposent la service, on vérifie le solde du bénéficiaire, puis on effectue la tâche
            //   Si le bénéficiaire a assez d'argent, on crée une tache confirmée de la tache
             if(beneficiaire.getJeton() - t.getPrix() >= 0) {
            	TacheConfirmee tConfirmee = new TacheConfirmee(t.getNom(),beneficiaire,t.getService(),t.getNbMembres(),t.getNbHeures(),lPart);
            	this.effectuerTache(tConfirmee, lPart);
            	System.out.println(t.getNom() + " pour "+ tConfirmee.getBeneficiaire().getNom()+" est validée!"); //le message qui indique que la tache pourra bien être réalisée
            } else {
                throw new Exception("ERROR: solde du demandeur insuffisant!");
            }
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    	// 0w0
//  Parcours la liste de membres jusqu'à avoir trouvé n membres proposant un service s(ps: on ne peut pas prendre le bénéficiaire lui-même)
    private ArrayList<Membre>	trouverParticipants(int nbPart, Service s, Reseau res, Membre benef) throws Exception {
        int i = 0;
        int n = 0;
        ArrayList<Membre>lMembres = new ArrayList<Membre>();
        //on crée une nouvelle liste du reseau mais sans beneficiaire
        ArrayList<Membre>MembresExceptBenef = new ArrayList <Membre>(); 
        for (Membre m: res.getMembres()) {
        	MembresExceptBenef.add(m);
        }
        while(MembresExceptBenef.get(n)!= benef) {
        	n++;
        }
        MembresExceptBenef.remove(MembresExceptBenef.get(n));
        //on ajoute les membres qui propose la service dans la liste de travailleurs pour la tache
        while(i < MembresExceptBenef.size() && lMembres.size() < nbPart) {
            if(MembresExceptBenef.get(i).getServiceList().contains(s)) { lMembres.add(MembresExceptBenef.get(i)); }
            i++;
        }
        if(lMembres.size() == nbPart) {
            return lMembres;
        } else {
            throw new Exception("ERROR: pas assez de membres pour compléter la tâche!");
        }
    }

    /** Effectue une tâche
     *  Débite le bénéficiaire du prix de la tâche
     *  Crédite les membres participants à part égale
     *  
     *  Note :
     *  Dans le cas où la répartition du prix de la tâche parmi les membres
     *  participants laissait un reste, ce reste est crédité à l'administrateur.     */
    private void effectuerTache(TacheConfirmee t, ArrayList<Membre> lMembres) {
    	//le prix final a payer de la tache en fonction de classe sociale du membre beneficiaire
    	int prixFinal = (int)(t.getPrix()*t.getBeneficiaire().getClasse().getDiv()); 
    	t.getBeneficiaire().debitSolde(prixFinal);
    	//le salaire final reçu des membres qui réalisent la tache
    	int prixIndividu = (prixFinal / lMembres.size());
    	for(Membre m : lMembres) {
            m.creditSolde(prixIndividu);
        	}
//        //on ajoute la tache à la liste de TacheConfirmée du réseau
        this.getReseau().ajoutTacheConf(t);
    }
}
