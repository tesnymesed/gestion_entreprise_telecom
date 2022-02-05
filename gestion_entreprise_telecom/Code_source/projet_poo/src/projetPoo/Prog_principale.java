package projetPoo;
import java.util.Vector;
import java.util.Scanner;
public class Prog_principale {
	
	private static Scanner sc;


	public static void main (String []args)
	{
		
		//la declaration
		int num,code_post,jour,mois,annee;
		String tel ;
		int num_rue;
		int i,n,nrc,debit,type,npi,choix,duree;
		
		String nom_rue,ville,rais_soc,nom,prenom;
		Date dd,date_naiss;
		double tarif;
		Adresse adr;
		Categorie categorie;
		Societe societe;
		Individu individu;
		Residentiel r;
       	Professionnel p;
		Vector <Abonnement> v=new Vector <Abonnement>();
		Vector <Abonnement> vr=new Vector <Abonnement>();
		Vector <Abonnement>vrp=new Vector <Abonnement>();//tableau des abonnement dont les clients sont en retard de paiement
		Vector <Abonnement>vrpr=new Vector <Abonnement>();//tableau des abonnement dont le contrat est résilié 
		Vector<Abonnement> p_actif=new Vector <Abonnement>();//tableau des abonnement dont les clients sont actifs
		//fin de declaration

		
		
		sc = new Scanner(System.in);
		
		if(vr.size()==0)
		System.out.println("Données non saisies");
		
		System.out.println("**Pour afficher les abonnements qui vont etre retardataire et immediatement resiliés veuillez remplir les données saisies au clavier** \n Pour acceder a lapplication tapez 1 \n Pour quitter l'application tapez 2 ");
		do
		{
		System.out.println("\nSaisissez votre choix");	
		choix=sc.nextInt();
		}
		while((choix!=1)&&(choix!=2));
		if(choix==1)
		{
			
			
			
			
			
			/****creation du tableau des abonnements professionnels****/
			
		System.out.println("Entrer le nombre d'abonnements professionnel");
		n=sc.nextInt();
		for(i=0;i<n;i++)
		{
			
			//les données de la societe numéro i
			System.out.println("\n******** les cordonnées de la societe ********\n");
			System.out.println("1/Entrer le numero de la  societe:");
			num=sc.nextInt();
			System.out.println("2/Entrer le numero de telephonne de la societe :");
	        tel =sc.next();
	        System.out.println("3/Entrer la raison sociale:");
			rais_soc =sc.next();
			System.out.println("4/Entrer le numero du registre de commerce NRC:");
			nrc =sc.nextInt() ;
			System.out.println("\n******** l'adresse de la  societe ********\n");
			System.out.println("1/Entrer le numéro de la rue : ");
		    num_rue=sc.nextInt() ;
			System.out.println("2/Entrer le nom de la rue : ");
	        nom_rue=sc.next() ;
			System.out.println("3/Entrer le code postal : ");
			code_post=sc.nextInt();
			System.out.println("4/Entrer la ville :");
			ville=sc.next();
			adr =new Adresse (num_rue,nom_rue,code_post,ville);
			
			
	societe =new Societe (num,tel,adr,rais_soc,nrc);
			//fin societe
	
			
			//categorie 
	System.out.println("\n******** la categorie de la connextion ********\n");
			System.out.println("1/entrer la durée en nombre de mois :");
			duree=sc.nextInt();
			System.out.println("2/Entrer le tarif:");
			tarif=sc.nextDouble();
		
			
			do 
			{
			System.out.println("3/Entrer le debit : \n 1*  256K \n 2*  512K \n 3*  1M \n 4*  2M ");
			 debit =sc.nextInt() ;
		   
			}while((debit>4)||(debit<1));
			
			do 
			{
				
				System.out.println("4/Entrer le type : \n 1*Ethernet \n 2*USB \n 3*WIFI");
				type =sc.nextInt();
				
			}while((type>3)||(type<1));
			 categorie = new Categorie (duree,tarif,debit,type);
	       //fin categorie		
			
	     		
			do
			{
			System.out.println("\n******** Entrer la date du dernier paiment ******** \n");
			System.out.println("jour:");
			jour =sc.nextInt();
			System.out.println("mois:");
			mois =sc.nextInt();
			System.out.println("année:");
			annee=sc.nextInt();
	       dd= new Date(jour,mois,annee);
			}while((dd.verifierDate()==false) || dd.comparer(dd, dd.ActuelDate())==1);
		
	p=new Professionnel (categorie,dd,societe);

			v.add(p);
			
			
		}
		
		 /****fin tableau professionnel****/
		
		//affichage tous les abonnements professionnel en retard de paiement pour une ville donnee
		if(n!=0) {
		System.out.println("\nEntrer la ville");
		
		 ville =sc.next();
		 int cpt=0;
System.out.println("\n******** les abonnements professionnel dont les clients sont en retard de paiement de la ville { "+ville+" } sont ************************************************************************************"); 
		for(i=0;i<v.size();i++)
		{
			if( (ville.equals(((Professionnel)v.get(i)).getClientPro().getAdr().getVille()) )&&(v.get(i).retard()))
					{
				cpt++;
				     v.get(i).afficher();
					}
		
		}
		if(cpt==0) {System.out.println("\t\taucun abonnement professionnel  dont le client est en retard de paiement de la ville ("+ville+")"); }else {
		//	System.out.println();
System.out.println("************************************************************************************************************************************************\n");	
		
		}
		}
		
		
		
		
		
		
		    /****creation du tableau des abonnements residentiels****/
		    
		System.out.println("Entrer le nombre d'abonnements Residentiel");
		n=sc.nextInt();
		for(i=0;i<n;i++)
		{
			
			//les données du client de l'abonnement numéro i
			System.out.println("\n******** les cordonnées du clients ********\n");
			System.out.println("1/Entrer le numero de l'individu:");
			num=sc.nextInt();
			System.out.println("2/Entrer le numero de telephonne de l'individu: ");
			tel =sc.next();
			System.out.println("3/Entrer le NPI:");
			  npi=sc.nextInt();
			
			System.out.println("4/Nom de l'individu:");
			 nom =sc.next();
			System.out.println("5/Prenom de l'individu:");
			prenom =sc.next() ;
			 date_naiss=new Date();
			do
			{
			System.out.println("6/Entrer la date de naissance: ");
			System.out.println("jour:");
			jour =sc.nextInt();
			date_naiss.setJour(jour);
			System.out.println("mois:");
		
			 mois =sc.nextInt();
			date_naiss.setMois(mois);
			System.out.println("année:");
			
			annee=sc.nextInt();
			date_naiss.setAnnee(annee);
			}while(date_naiss.verifierDate()==false);
			
			System.out.println("\n******** l'adresse de l'individu ********\n");
			System.out.println("1/Entrer le numéro de la rue : ");
		      num_rue=sc.nextInt() ;
			System.out.println("2/Entrer le nom de la rue : ");
			 nom_rue=sc.next() ;
			System.out.println("3/Entrer le code postal : ");
			 code_post=sc.nextInt();
			System.out.println("4/Entrer la ville :");
	      	 ville=sc.next();
			  adr =new Adresse (num_rue,nom_rue,code_post,ville);
	
			 individu =new Individu (num,tel,adr,npi,nom,prenom,date_naiss);
			
			//fin client
			
			//categorie
				System.out.println("\n******** la categorie de la connextion ********\n");
			System.out.println("1/entrer la durée en nombre de mois :");
			duree=sc.nextInt();
			System.out.println("2/Entrer le tarif :");
			tarif=sc.nextDouble();
			
			do {
			System.out.println("3/Entre le debit : \n 1*  256K \n 2*  512K \n 3*  1M \n 4*  2M ");
			
			debit=sc.nextInt() ;
			}while((debit >4) || (debit <=0));
			
			do {
				
		    System.out.println("4/Entrer le type : \n 1*Ethernet \n 2*USB \n 3*WIFI");
			type=sc.nextInt() ;
			}while(type >3 || type <=0);
			categorie =new Categorie (duree ,tarif,debit,type);
            //fin categorie		
		
			do
			{
			System.out.println("\n******** Entrer la date du dernier paiement ********\n");
			System.out.println("jour:");
			jour =sc.nextInt();
			System.out.println("mois:");
			mois =sc.nextInt();
			System.out.println("année:");
			annee=sc.nextInt();
			dd=new Date(jour,mois,annee);
			}while((dd.verifierDate()==false) || dd.comparer(dd, dd.ActuelDate())==1);
			
			
			
		    r=new Residentiel (categorie,dd,individu);
			vr.add(r);
		
		    }
		
		
		        /*** fin du tableau residentiel***/
		
		
		
		
		
		
		    //affichage tous les abonnements residentiels resiliés
		if(n!=0) {
System.out.println("\n########## les abonnements residentiel dont le contrat est résilié ###########################################################################################################");		
		  int cpt=0;
		    for(i=0;i<vr.size();i++)
		    {
			if(vr.get(i).resilier())
				vr.get(i).afficher();
			    cpt++;
		    }
		    if(cpt==0) {
		    System.out.println("\t\taucun Abonnement residentiel dont le contrat est résilé"); 
		    }else {
		    	//System.out.println();
System.out.println("###################################################################################################################################################\n");	
		    
		    }
		
		
		}
		
		
		    
		    
     		    
		    
		    //extraire les abonnements professionnel  dont les contat est résilié en meme temps  leur affichage
System.out.println("\n########## abonnements dont les contrat est résilé ######################################################################################################################\n");
	     	System.out.println("");
	     	i=0;
			while(i<v.size())
			{
			if(v.get(i).resilier())
			{
			    v.get(i).afficher();
			    vrpr.add((v.get(i)));				
			    v.remove(i); 
			}else {i++;}
			
			}
			System.out.println();
			
			
			
			
			
			//extraire les abonnements residentiels dont le contat est  résilié en meme temps leur affichage
			i=0;
			while(i<vr.size())
			{
			  if(vr.get(i).resilier())
			  {
			  vr.get(i).afficher();
			  vrpr.add((vr.get(i)));
			  vr.remove(i);
			  }else {i++;}
			}
			//System.out.println();
System.out.println("###############################################################################################################################################################\n");				
		
 

		
	    
		  //extraire les abonnements professionnel dont les client sont en retard de paiement en meme temps leur affichage
System.out.println("\n********** abonnements en retard ********************************************************************************************************************************\n");  
		  i=0;
		  while(i<v.size())
		  {
		    if(v.get(i).retard() && v.get(i).resilier()==false)
		    {
		       v.get(i).afficher();
				vrp.add((v.get(i)));
				v.remove(i);
			}else {i++;}
		}
		  System.out.println();
		
		  
		  
		  
		  
		  //extraire les abonnements residentiels dont les clients sont en  retard de paiement en meme temps leur affichage 
		
		  i=0;
		  while(i<vr.size())
		  {
			if(vr.get(i).retard() && vr.get(i).resilier()==false)
			{
				vr.get(i).afficher();
				vrp.add((vr.get(i)));
				vr.remove(i);
			}else {i++;}
		  }
		 // System.out.println();
System.out.println("********************************************************************************************************************************************************************************\n");

		  
			
		  
		  
		  
		
		  //affichage tous les abonnement actif dans le tableau 
System.out.println("\n---------- abonnements dont les clients sont actifs ---------------------------------------------------------------------------------------------------------------------------------------------\n");
		
		  for(i=0;i<v.size();i++)
		  {
			  if(v.get(i).actif()) {
			  v.get(i).afficher();
			  }
		  }
		  System.out.println();
			
		  
		  
	      
		  for(i=0;i<vr.size();i++)
		  {
			  if(vr.get(i).actif()) {
			  vr.get(i).afficher();
			  }
		  }
		  //System.out.println();
		  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");	
		
		//extraire les abonnements  dont les clients sont actifs 
		 
		    for(i=0;i<v.size();i++)
		    {
		    	if(v.get(i).actif())
		    	{
		    		p_actif.add((Professionnel )v.get(i));
		    	}
		    }
		    
		   

		    for(i=0;i<vr.size();i++)
		    {
		    	if(vr.get(i).actif())
		    	{
		    		p_actif.add((Residentiel)vr.get(i));
		    	}
		    }
		    

		  
		  
		  
		  
		  
		//abonnements dont les clients sont devenu  retardataire 
		System.out.println("\n********** abonnements  dont les clients sont devenus retardatiare aujourd'hui sont *********************************************************************************************************\n");
	Date x;
		for(i=0;i<vrp.size();i++)
		  {
			x=vrp.get(i).getDate_debutconnection();
			x.ajoutjour_date(vrp.get(i).getCategorie().getDuree()*30);
			
               if(x.comparer(x,x.ActuelDate())==0) {
				  vrp.get(i).afficher();
				
			    } 
		  }
		//System.out.println();
		System.out.println("*******************************************************************************************************************************************************************************\n\n");	
		
		
		
		   // abonnements dont le contrat est résilé
				System.out.println("\n##########abonnements dont le contrat est  immediatement résilé aujourd'hui #############################################################################################\n");
	
				for(i=0;i<vrpr.size();i++)
				  {
					x=vrpr.get(i).getDate_debutconnection();
					x.ajoutjour_date(vrpr.get(i).getCategorie().getDuree()*30+90);
					
		               if(x.comparer(x,x.ActuelDate())==0) {
						  vrpr.get(i).afficher();
						
					    } 
				  }
			//System.out.println();
				System.out.println("################################################################################################################################################\n\n\n");

						    
			    Abonnement a = null ;
			    Abonnement ab =new Abonnement();
			    System.out.println("++++++++++ Entrer le nombre de client qui sont en retard de paiement et qui veulent se débarasser de leurs dettes +++++++++++++++++++++++++++++++++++");
			    int s =sc.nextInt();
			    int numero ;
			    for(i=0;i<s;i++)
			    {
			    	System.out.println(i+1+"/entrer le numero du client");
			    	numero=sc.nextInt();
			    	a= ab.dette(numero, vrp);
			    	
			    	if(a!= null )
			    	{
			    		System.out.println("entrer la durée en nombre de mois :");
						duree=sc.nextInt();
						do 
						{
						System.out.println("Entrer le debit : \n 1*  256K \n 2*  512K \n 3*  1M \n 4*  2M ");
						 debit =sc.nextInt() ;
					   
						}while((debit>4)||(debit<1));
						
					 a.getCategorie().setDuree(duree);
					 a.getCategorie().setDebit(debit);
					 
			    		a.relancer(a, p_actif);
			    		
			    		
			    	}
			    	else
			    		System.out.println("   ***le client n'est pas en retard de paiement ni le contat résilié***\n\n");
			    	
			    	
			    }
			    
			    System.out.println("++++++++++ entrer le nombre de client dont le contrat est résilié et qui veulent se debarasser de leurs dettes +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			    s=sc.nextInt();
			    
			    for(i=0;i<s;i++)
			    {
			    	System.out.println(i+1+"/entrer le numero du client");
			    	numero =sc.nextInt();
			    	a=ab.dette(numero, vrpr);
			    	if(a!=null)
			    	{
			    		
			    		System.out.println("entrer la durée en nombre de mois :");
						duree=sc.nextInt();
						do 
						{
						System.out.println("Entrer le debit : \n 1*  256K \n 2*  512K \n 3*  1M \n 4*  2M ");
						 debit =sc.nextInt() ;
					   
						}while((debit>4)||(debit<1));
						
					 a.getCategorie().setDuree(duree);
					 a.getCategorie().setDebit(debit);
					 
			    		a.relancer(a, p_actif);
			    	}
			    	else
			    		System.out.println("     *** le contrat du client n'est pas résilié ***\n\n");
			    }
			    
			  
			    	//affichage abonnements actif
			    System.out.println("\n\n\n---------- abonnments actifs  --------------------------------------------------------------------------------------------------------------------------------\n"); 
			    for(i=0;i<p_actif.size();i++)
			    {
			    	p_actif.get(i).afficher();
			    }
			    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
	
		}
		else
		{
		
		  System.out.println("Merci d'avoir consulter notre application !");
		     
		
	
		}
		
		
		
	   
	}

	}
