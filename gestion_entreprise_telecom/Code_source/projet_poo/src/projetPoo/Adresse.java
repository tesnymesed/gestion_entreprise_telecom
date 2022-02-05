package projetPoo;

public class Adresse {
	//les attributs de la classe adresse
	private int num_rue ;
	private String nom_rue ;
	private int code_post;
	private String ville;

	//méthodes associées a la classe "Adresse"

	//constructeur permet d'initialiser les valeurs des attributs de l'objet instancié a null
	public Adresse()
	{
	
	}
	//constructeur permet d'initialiser les valeurs des attributs de l'objet instancié 
	public Adresse(int num_rue , String nom_rue ,int code_post , String ville)
	{
		this.num_rue=num_rue;
		this.nom_rue=nom_rue;
		this.code_post=code_post;
		this.ville=ville;
	}





	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String toString() {
		return "Num_rue:" + this.num_rue + ", Nom_rue:" + this.nom_rue + ", Code_post:" + this.code_post + ", Ville:" + this.ville;
	}

	public void afficher()
	{
		System.out.println(this.toString());
	}

}
