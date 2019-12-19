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
		Tache tache1 = new Tache("tache1",jardinage,2,2);
		Tache tache2 = new Tache("tache2",cuisiner,3,1.5);
		Tache tache3 = new Tache("tache3",coder,1,5);
		//Ajout des taches au réseau "echange"
		lea.getReseau().ajoutTache(tache1);
		lea.getReseau().ajoutTache(tache2);
		lea.getReseau().ajoutTache(tache3);
		//Afficher les Taches proposées du réseau
		lea.getReseau().afficherLesTaches();
		//Un membre demande la validation d'une tache
			//bénéficiaire = classe normale
		lea.getReseau().getMembre("paul").demanderValid(tache1);
		lea.getReseau().afficherLesMembresAvecInformations();
			//bénéficiaire = classe demie
		lea.getReseau().getMembre("marie").demanderValid(tache3);
		lea.getReseau().afficherLesMembresAvecInformations();
			//bénéficiaire = classe zero
		lea.getReseau().getMembre("lina").demanderValid(tache3);
		//Affiche la somme du jeton restant du membre
//		System.out.println(lea.getReseau().getMembre("lina").getJeton());
		//Affiche les informations de tous les membres du reseau sous forme de liste
		lea.getReseau().afficherLesMembresAvecInformations();
		//Un membre demande la validation d'une tache qui ne peut pas être executer(pas assez de membres)
//		lea.getReseau().getMembre("lina").demanderValid(tache2);
		//Afficher les Taches Confirmés
//		lea.getReseau().afficherLesTachesConfirmees();
		System.out.print(lea.getReseau().getMembre("lina").getClasse().getDiv());
		System.out.print("end");
		
	}

}
