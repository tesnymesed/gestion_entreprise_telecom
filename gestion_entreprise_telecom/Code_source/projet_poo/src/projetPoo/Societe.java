package projetPoo;

public class Societe extends Client {
	//les attributs de la classe "societe"
	
private String raison_soc ;
		private int nrc ;
		
		//méthodes associées a la classe "societe"
		
		//constructeur permet d'initialiser les valeurs des attributs de l'objet instancié a null
		
		public Societe ()
		{
			
		}
		
		public Societe (int num_client,String num_tel,Adresse adr,String raison_soc,int nrc)
		{
			super(num_client,num_tel,adr);
			this.raison_soc=raison_soc ;
			this.nrc=nrc;
		}



		public String toString() {
			return super.toString()+" , Raison_soc=" + raison_soc + ", Num_Regcom=" + nrc+"]"+"\nAdresse_Client N°"+super.num_client+"("+super.adr.toString()+")" ;
		}
		
		public void afficher ()
		{
			System.out.println(this.toString());
		}
		
		
		


	
}
