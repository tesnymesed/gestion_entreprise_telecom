package projetPoo;

public class Categorie {
private int duree;
private  double tarif;
private Debit debit;
private Type type;


public Categorie(int duree, double tarif, int debit,int type) {
	
	this.duree = duree;
	this.tarif = tarif;
    this.debit=Debit.values()[debit-1];
    this.type=Type.values()[type-1];
    
	}

public int getDuree() {
	return duree;
}
public void setDuree(int duree) {
	this.duree = duree;
}

public void setDebit(int debit) {
	this.debit = Debit.values()[debit-1];
}


public String toString() {
	return "Debit:"+this.debit.toString().substring(1)+" , Duree:"+this.duree+" mois  , Type:"+this.type+" , Tarif:"+this.tarif+" DA";
}

public void afficher() {
	System.out.println(this.toString());
}


}
