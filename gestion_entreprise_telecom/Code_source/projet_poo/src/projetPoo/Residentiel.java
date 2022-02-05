package projetPoo;

public class Residentiel extends Abonnement{

private Individu clientRes;


public Residentiel (Categorie categorie, Date date_debutconnection,Individu clientRes) {
	
	super(categorie,date_debutconnection);
	this.clientRes=clientRes;
}


public Individu getClientRes() {
	return clientRes;
}


public void setClientRes(Individu clientRes) {
	this.clientRes = clientRes;
}
public String toString() {
	return clientRes.toString()+"\n"+super.toString()+"\n";
}
public void afficher() {
	System.out.println(this.toString());
}





	
	
	
	
}
