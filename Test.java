package pooSystem;

import java.util.ArrayList;
public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Administrateur lea = new Administrateur("lea");
		//Création réseau à Lea
		lea.creationReseau("echange");
		//Ajout Membres
		lea.creationAjoutMembre("paul",new ClasseNormale()); 
		lea.creationAjoutMembre("lina", new ClasseZero());
		lea.creationAjoutMembre("marie", new ClasseDemie());
		//Création des Services
		Service jardinage = new Service("Jardinage",10);	
		Service cuisiner = new Service("Cuisine",6);
		Service coder = new Service("Coder", 25);
		//Création liste de Service pour faciliter ajout aux Membres
		ArrayList<Service> lServices = new ArrayList<Service>(); 
		lServices.add(jardinage);/** il y a des services qui se répétent dans la liste, on garde qu'une examplaire */
		lServices.add(cuisiner);
		lServices.add(coder);
		//afficher les membres du réseau
		lea.getReseau().afficherLesMembres();
		//ajout d'une service ou une liste de services à un Membre 
		lea.getReseau().getMembre("paul").ajoutService(jardinage);
		lea.getReseau().getMembre("lina").ajoutListeServices(lServices); 
		lea.getReseau().getMembre("marie").ajoutListeServices(lServices);
		//Création des taches
		Tache tache1 = new Tache(jardinage,2,2);
		Tache tache2 = new Tache(cuisiner,3,1.5);
		Tache tache3 = new Tache(coder,1,5);
		lea.getReseau().a
		
		System.out.print("end");
		
	}

}
