package projetPoo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
private int jour,mois,annee;

public Date() {

	this.jour = 0;
	this.mois = 0;
	this.annee = 0;
}
public Date(int jour, int mois, int annee) {

	this.jour = jour;
	this.mois = mois;
	this.annee = annee;
}

public int getJour() {
	return jour;
}

public void setJour(int jour) {
	this.jour = jour;
}

public int getMois() {
	return mois;
}

public void setMois(int mois) {
	this.mois = mois;
}

public int getAnnee() {
	return annee;
}

public void setAnnee(int annee) {
	this.annee = annee;
}
public String toString() {
	return this.jour+"/"+this.mois+"/"+this.annee;
}
public void afficher() {
	System.out.println(this.toString());
} 
public boolean bissextile() {
	if(this.annee % 4 ==0) {
		if(this.annee % 100 ==0) {
			if(this.annee % 400 ==0) {
				return true;
			}else {return false;}
		}else {return true;}
	}else {return false;}
}

public Date ActuelDate() {
	Date date_act=new Date();
	LocalDate x=LocalDate.now();
	
     date_act.jour=Integer.valueOf(DateTimeFormatter.ofPattern("dd").format(x));
     date_act.mois=Integer.valueOf(DateTimeFormatter.ofPattern("MM").format(x));
     date_act.annee=Integer.valueOf(DateTimeFormatter.ofPattern("yyyy").format(x));

	return date_act;
}
//methode qui permet de justifier si la date entrer est juste 
	//les mois de 1 a 12
	//les jours selon le mois de plus ils doivent etre superiere a 0
	//l'annee positive
	
	public boolean  verifierDate()
	{
		
		if(this.annee>0) {
		      if(this.mois>0) {
                  if(this.jour>0) {
                	  
                	  
if(((this.mois==1)||(this.mois==3)||(this.mois==5)||(this.mois==7)||(this.mois==8)||(this.mois==10)||(this.mois==12))&& (this.jour<32)) {
	return true;
}
if(((this.mois==4)||(this.mois==6)||(this.mois==9)||(this.mois==11))&& (this.jour<31)) {
	return true;
}
if(this.mois==2 && this.bissextile() && this.jour<30) {
	
	return true;
}
if(this.mois==2 && !this.bissextile() && this.jour<29) {
	
	return true;
}  
                  }  			
		     }
		}
return false;
}
		


public int comparer(Date d1,Date d2) {
	
	if(d1.getAnnee()>d2.getAnnee()) {return 1;}
	if(d2.getAnnee()>d1.getAnnee()) {return -1;}
	
	if(d1.getMois()>d2.getMois()) {return 1;}
	if(d2.getMois()>d1.getMois()) {return -1;}
	
	if(d1.getJour()>d2.getJour()) {return 1;}
	if(d2.getJour()>d1.getJour()) {return -1;}
	
	return 0;
}

public void ajoutjour_date(int nbjour) {
	
	int n,r=0;
	n=this.mois;
	
	this.jour=this.jour+nbjour;
	
	while(!this.verifierDate()) {
		if((n==1)||(n==3)||(n==5)||(n==7)||(n==8)||(n==10)||(n==12)) {
			r=31;
		}
		if((n==4)||(n==6)||(n==9)||(n==11)) {
			r=30;
		}
		if(n==2 && this.bissextile()) {
			r=29;
		}
		if(n==2 && !this.bissextile()) {
			r=28;
		}
 
       this.jour=this.jour-r;
       this.mois++;
		
		
		if(this.mois>12) {this.mois=this.mois-12;this.annee++;}
		n++;
	
	}	
}


}
