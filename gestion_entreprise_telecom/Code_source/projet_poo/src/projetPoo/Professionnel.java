package projetPoo;

public class Professionnel extends Abonnement {
	private Societe clientPro;


	public Professionnel (Categorie categorie, Date date_debutconnection,Societe clientPro) {
		super(categorie,date_debutconnection);
		this.clientPro=clientPro;
	}


	public Societe getClientPro() {
		return clientPro;
	}


	public void setClientPro(Societe clientPro) {
		this.clientPro = clientPro;
	}
	public String toString() {
		return clientPro.toString()+"\n"+super.toString()+"\n";
	}
	public void afficher() {
		System.out.println(this.toString());
	}



}