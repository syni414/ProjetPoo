package pooSystem;

public class Service {
    private String  nomServ;     // Un service possède un nom
    private int coutH;          // Un service possède un coût horaire

    public Service(String nomServ, int coutH) {
        this.nomServ = nomServ;
        this.coutH = coutH;
    }

    public String getNomServ(){
    	return this.nomServ;
    }
    public int getCoutH() {
    	return this.coutH;
    }
    public String toString() {
    	return this.nomServ;
    }
}