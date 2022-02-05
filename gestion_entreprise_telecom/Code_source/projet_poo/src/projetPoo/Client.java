package projetPoo;

public class Client {
    protected int num_client ;
	protected String num_tel ;
	protected Adresse adr ;
	
	//méthodes associées a la classe "Client"
	//constructeur permet d'initialiser les valeurs des attributs de l'objet instancié a null
	public Client ()
	{
		
	}
	//constructeur permet d'initialiser les valeurs des attributs de l'objet instancié 
	public Client (int num_client , String num_tel,Adresse adr)
	{
		this.adr=adr;
		this.num_client=num_client ;
		this.num_tel=num_tel;
		
	}

	public int getNum_client() {
		return num_client;
	}

	public void setNum_client(int num_client) {
		this.num_client = num_client;
	}


	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}
     

	public String toString() {
		return " \nClient N°" + this.num_client + ":[ Num_tel=" + this.num_tel ;
	}
	
	public void afficher()
	{
		System.out.println(this.toString());
	}
	

	
}
