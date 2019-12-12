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
        res.ajoutMembre(new Membre(nom, classeSociale));  /** petite modification*/
    }
    
    /** On prend tache et le beneficiaire(celui qui demande la tache) en parametre */
    public boolean	valider(Tache t, Membre beneficiaire) throws Exception {
        try {
            ArrayList<Membre> lPart = new ArrayList<Membre>(); 
            lPart =	trouverParticipants(t.getNbMembres(), t.getService(), this.res);
            
            //	Si il y a assez de membres, on vérifie le solde du bénéficiaire, puis on effectue la tâche
            /** Si le bénéficiaire a assez d'argent, on crée une tache confirmée de la tache
             * 
             */
            if(beneficiaire.getJeton() - t.getPrix() >= 0) {
            	TacheConfirmee tConfirmee = new TacheConfirmee(beneficiaire,t.getService(),t.getNbMembres(),t.getNbHeures(),lPart);
            	this.effectuerTache(tConfirmee, lPart);
                return true;
            } else {
                throw new Exception("ERROR: solde du demandeur insuffisant!");
            }
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    	// 0w0
//    public void	valider(ArrayList<Tache> lTaches) throws Exception {
//        for(Tache t : lTaches) {
//            this.valider(t);
//        }
//    }   
//  Parcours la liste de membres jusqu'à avoir trouvé n membres proposant un service s
    private ArrayList<Membre>	trouverParticipants(int nbPart, Service s, Reseau res) throws Exception {
        int                 i           = 0;
        ArrayList<Membre>   lMembres    = new ArrayList<Membre>();

        while(i < res.getMembres().size() && lMembres.size() < nbPart) {
            if(res.getMembres().get(i).getServiceList().contains(s)) { lMembres.add(res.getMembres().get(i)); }
            i++;
        }

        if(lMembres.size() == nbPart) {
            return lMembres;
        } else {
            throw new Exception("ERROR: pas assez de membres pour compléter la tâche!");
        }
    }

    /* Effectue une tâche
     *  Débite le bénéficiaire du prix de la tâche
     *  Crédite les membres participants à part égale
     *  
     *  Note :
     *  Dans le cas où la répartition du prix de la tâche parmi les membres
     *  participants laissait un reste, ce reste est crédité à l'administrateur.     */
    private void effectuerTache(TacheConfirmee t, ArrayList<Membre> lMembres) {
        t.getBeneficiaire().debitSolde(t.getPrix());

        int prixIndiv   = t.getPrix() / t.getNbMembres();
        this.creditSolde(t.getPrix() % t.getNbMembres());

        for(Membre m : lMembres) {
            m.creditSolde(prixIndiv);
        }
    }
}