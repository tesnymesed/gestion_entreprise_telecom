package projetPoo;

import java.util.Vector;


public class Abonnement {

	protected Categorie categorie;
	protected Date date_debutconnection;
	protected Date date_finconnection;
	protected Date date_dernierpaiment;
	protected Client client ;
	
	public Abonnement()
	{
		
	}	
	public Abonnement(Categorie categorie, Date date_dernierpaiment) {
		this.categorie = categorie;
		
		
		this.date_dernierpaiment = date_dernierpaiment;
		
		this.date_finconnection=new Date();
        this.date_finconnection.setJour(this.date_dernierpaiment.getJour()); 
        this.date_finconnection.setMois(this.date_dernierpaiment.getMois());
        this.date_finconnection.setAnnee(this.date_dernierpaiment.getAnnee());
        
		this.date_finconnection.ajoutjour_date(this.categorie.getDuree()*30+30);
		
		
		this.date_debutconnection = date_dernierpaiment;
		
	
		
	}

	public Client getClient ()
	{
		return  client ;
	}
	
	public void setClient (Client client)
	{
		this.client=client;
	}

	public Categorie getCategorie() {
		return categorie;
	}


	

	public Date getDate_debutconnection() {
		return date_debutconnection;
	}


	public void setDate_debutconnection(Date date_debutconnection) {
		this.date_debutconnection = date_debutconnection;
	}

	public Date getDateDernierPaiement ()
	{
		return this.date_dernierpaiment;
	}
	public void setDateDernierPaiement(Date dateDernierPaiement)
	{
		this.date_dernierpaiment=dateDernierPaiement ;
	}
     public void setDateFinDeCnx (Date fin)
     {
	this.date_finconnection=fin;
     }
public Date getDateFinDeCnx ()
{
	return this.date_finconnection;
}

	public String  toString() {
		//return
		String s;
		Date d=new Date();
		d.setJour(this.date_debutconnection.getJour());
		d.setMois(this.date_debutconnection.getMois());
		d.setAnnee(this.date_debutconnection.getAnnee());
		d.ajoutjour_date(this.categorie.getDuree()*30);
		
	 s=	"Categorie de connexion:("+categorie.toString();
	 s=s+")\nDate_dernier_paiment:"+this.date_dernierpaiment.toString();
	 s=s+" , Date_debut_connexion:"+this.date_debutconnection.toString();
	 if(this.retard()==true && this.resilier()==false) {
		 s=s+" , Date_debut_retard:"+d.toString();
		}	
	 s=s+" , Date_fin_connexion:"+this.date_finconnection.toString();
	 if(this.resilier()==true) {
		 d.ajoutjour_date(90);
		 s=s+" , Date_de_resilation:"+d.toString();
		}
	 

	
	return s;
	}
	public void afficher() {
		System.out.println(this.toString());
	} 
	
	public boolean retard() {
Date d=new Date();
d.setJour(this.date_debutconnection.getJour());
d.setMois(this.date_debutconnection.getMois());
d.setAnnee(this.date_debutconnection.getAnnee());
d.ajoutjour_date(this.categorie.getDuree()*30);
		if( d.comparer( d,d.ActuelDate() )>0) {return false;}
		return true;
	}
	public boolean resilier() {
		Date d=new Date();
		d.setJour(this.date_debutconnection.getJour());
		d.setMois(this.date_debutconnection.getMois());
		d.setAnnee(this.date_debutconnection.getAnnee());
		d.ajoutjour_date(this.categorie.getDuree()*30+90);
		
				if( d.comparer( d,d.ActuelDate() )>0) {return false;}
		
		return true;
	}
	public boolean actif() {
		
				if( this.retard()==true) {return false;}
		
		return true;
	}
	//methodes rajoutées

	public void relancer (Abonnement a , Vector <Abonnement>b)
	{
		Date d=new Date();
		
		a.setDate_debutconnection(d.ActuelDate());
		a.setDateDernierPaiement(d.ActuelDate());
		
		d.setAnnee(a.getDate_debutconnection().getAnnee());
		d.setMois(a.getDate_debutconnection().getMois());
		d.setJour(a.getDate_debutconnection().getJour());
		
		d.ajoutjour_date(this.categorie.getDuree()*30+30);
		a.setDateFinDeCnx(d);
		
		b.add(a);
		
	}



	//methode dette elle retourne l'abonnement qui a payé ses dettes


	public Abonnement dette( int numero, Vector <Abonnement>v)
	{
		int i ;
		for(i=0;i<v.size();i++)
		{
			if(v.get(i) instanceof Residentiel ) {
				if( ((Residentiel)v.get(i)).getClientRes().getNum_client()==numero) {
					return v.get(i);
				}
			}
			
			if(v.get(i) instanceof Professionnel ) {	
			if( ((Professionnel)v.get(i)).getClientPro().getNum_client()==numero) {
				return v.get(i);
			}
			}
		}
		return null ;
	}
	
	
	
	
	
	
	
	
}

