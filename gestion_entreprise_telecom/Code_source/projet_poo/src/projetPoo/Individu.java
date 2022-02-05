package projetPoo;

public class Individu extends Client {
	//les attributs de la classe Individu
		private int npi;
		private String nom ;
		private String prenom ;
		private Date date_naiss ;
		
		//méthodes associées a la classe "Individu"
		//constructeur permet d'initialiser les valeurs des attributs de l'objet instancié a null
		public Individu ()
		{
			
		}
		
		public Individu (int num_client,String num_tel,Adresse adr,int npi,String nom,String prenom ,Date date_naiss)
		{
			super(num_client,num_tel,adr);
			this.npi=npi;
			this.nom=nom;
			this.prenom=prenom;
			this.date_naiss=date_naiss;
			
			
		}

		public int getNpi() {
			return npi;
		}

		public void setNpi(int npi) {
			this.npi = npi;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public Date getDate_naiss() {
			return date_naiss;
		}

		public void setDate_naiss(Date date_naiss) {
			this.date_naiss = date_naiss;
		}

		
		public String toString() {
			return super.toString()+" , NPI=" + npi + ", Nom=" + nom + ", Prenom=" + prenom+"]"+"\nAdresse_Client N°"+super.num_client+"("+super.adr.toString()+")";
		}
		
		public void afficher()
		{
			System.out.println(this.toString());
		}



}
