package pooSystem;

import java.util.ArrayList;

public class TacheConfirmee extends Tache {
	private Membre beneficiaire;
	private ArrayList <Membre> lMembres;
	public TacheConfirmee(Membre beneficiaire, Service serv, int nbMembres, double nbHeures,ArrayList <Membre> lMembres) {
		super(serv, nbMembres, nbHeures);
		this.beneficiaire = beneficiaire;
		this.lMembres = lMembres;
	}
	
	//methodes
			//les gets:
		public Membre getBeneficiaire() {
			return beneficiaire;
		}
		public ArrayList<Membre> getListeMembres(){
			return lMembres;
		}
}
