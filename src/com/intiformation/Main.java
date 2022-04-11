package com.intiformation;

import java.util.ArrayList;
import java.util.Scanner;

import com.intiformation.Exception.nbMedicamentNegException;
import com.intiformation.Exception.notEnoughStockException;



public class Main {
	public static ArrayList<Client> ListeClient = new ArrayList<Client>();
	protected static ArrayList<Medicament> ListeMedicament = new ArrayList<Medicament>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client c1 = new Client("Jean", 12);
		Client c2 = new Client("Pierre", 25);
		Client c3 = new Client("Paul", 6);
		Client c4 = new Client("Jacques", 2);
		
		ListeClient.add(c1);
		ListeClient.add(c2);
		ListeClient.add(c3);
		ListeClient.add(c4);
		
		Medicament m1 = new Medicament("Doliprane", 5, 18);
		Medicament m2 = new Medicament("Dafalgan", 6, 22);
		
		ListeMedicament.add(m1);
		ListeMedicament.add(m2);
		
		
		
		int key; 
		do {
			System.out.println("\nQue voulez vous faire ? "
					+ "\n\n1 Afficher les informations d'un client ou d'un médicament"
					+ "\n2 Approvisionner"
					+ "\n3 Traiter un Achat"
					+ "\n4 Quitter");
		key = sc.nextInt();
		switch (key) {
		case 1 : 
			afficherInfos();
			
			break;
		case 2 : 
			try {
				approvisionner();
			} catch (nbMedicamentNegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
			
		case 3 : 
			int nume = lireClient ();
			int num = lireMedicament();
			try {
				achat(nume, nume);
			} catch (notEnoughStockException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		
				System.out.println("Le stock maximum restant est de " + ListeMedicament.get(num).getStock() + " unités. Voulez vous acheter ce qu'il reste en stock ?"
						+ "\n1 : Oui "
						+ "\n2 : Non");	
				 if(sc.nextInt()==1) 
				 {
					 ListeMedicament.get(num).setStock(ListeMedicament.get(num).getStock()-ListeMedicament.get(num).getStock());
					 ListeClient.get(nume).setCredit(ListeMedicament.get(num).getStock()*ListeMedicament.get(num).getPrix()+ListeClient.get(nume).getCredit());
					 System.out.println("Combien le client a t'il payé ?");
					 ListeClient.get(nume).setCredit(-sc.nextInt()+ListeClient.get(nume).getCredit());
					 System.out.println("Voici le nouveau stock pour le " + ListeMedicament.get(num).getNom()+ " : " + ListeMedicament.get(num).getStock());
					 System.out.println("Voici le nouveau credit du client " + ListeClient.get(nume).getNom()+ " : " + ListeClient.get(nume).getCredit());
				 }
				 else
				 {
					 System.out.println("Ce n'est pas très logique mais d'accord");
				 }
			}
			
			
			
			break;
			
		case 4 :
			
			System.out.println("Fin de l'application!");
			
			break;	
			
			
		default:
			break;
	
	}
		} while (key>0 && key<4);
		
}
	
	public static void afficherInfos()
	{
		System.out.println("Quels informations voulez vous afficher ? "
				+ "\n1 : Client "
				+ "\n2 : Medicament");
		
		if(sc.nextInt()==1) 
		{
			int num = lireClient ();
			if (num != -1)
			{
				System.out.println("Voici les information du client : " + ListeClient.get(num).getNom() + "\n " + ListeClient.get(num));	
			}
		}
		else
		{
			int num = lireMedicament ();
			if (num != -1)
			{
				System.out.println("Voici les information du médicament : " + ListeMedicament.get(num).getNom() + "\n " + ListeMedicament.get(num));	
			}
		}
		
	}

	
	public static void approvisionner() throws nbMedicamentNegException
	
	{
		int num = lireMedicament();
		System.out.println("Quelle quantitée voulez-vous approvisionner ? (Le stock actuel pour le " + ListeMedicament.get(num).getNom() + " est de : " + ListeMedicament.get(num).getStock()+")");
		int unite = sc.nextInt();
		
		if (num != -1) 
			if (unite<0)
				throw new nbMedicamentNegException();
			else
			{
				ListeMedicament.get(num).setStock(unite+ListeMedicament.get(num).getStock());
				System.out.println("Voici le nouveau stock pour le " + ListeMedicament.get(num).getNom()+ " : " + ListeMedicament.get(num).getStock());
			}

	}
	
	public static int achat(int num, int nume) throws notEnoughStockException
	{
		
			
		System.out.println("Quelle est la quantité achetée ?");
		int quantite = sc.nextInt();
		
		if (nume != -1 && num !=-1)
					
			if (ListeMedicament.get(num).getStock() - quantite>=0)
			{
				
				ListeMedicament.get(num).setStock(-quantite +ListeMedicament.get(num).getStock());
				ListeClient.get(nume).setCredit(quantite*ListeMedicament.get(num).getPrix()+ListeClient.get(nume).getCredit());
				System.out.println("Combien le client a t'il payé ?");
				ListeClient.get(nume).setCredit(-sc.nextInt()+ListeClient.get(nume).getCredit());
				System.out.println("Voici le nouveau stock pour le " + ListeMedicament.get(num).getNom()+ " : " + ListeMedicament.get(num).getStock());
				System.out.println("Voici le nouveau credit du client " + ListeClient.get(nume).getNom()+ " : " + ListeClient.get(nume).getCredit());
			}
			else
			{
				throw new notEnoughStockException();
			}
		return num & nume;
	}
	
	
	public static int lireClient ()
	{
		int nume =-1;
		System.out.println("Veuillez saisir le nom du client : ");
		String nom = sc.next();
		boolean TrouverNom = false;
		
		for(int i = 0; i < ListeClient.size(); i++)
		{
			
			if(ListeClient.get(i).getNom().contains(nom))
			{
				TrouverNom = true; 
				nume = i;
			}
									
		}
		
		if (TrouverNom == false) {
		
		System.err.println("Il n'existe pas de client à ce nom essayez à nouveau");	
		return lireClient ();
		
		}
		return nume;
	}
	
	public static int lireMedicament ()
	{
		int num =-1;
		System.out.println("Veuillez saisir le nom du médicament : ");
		String nom = sc.next();
		boolean TrouverNom = false;
		
		for(int i = 0; i < ListeMedicament.size(); i++)
		{
			
			if(ListeMedicament.get(i).getNom().contains(nom))
			{
				TrouverNom = true; 
				num = i;
		
			}
	
		}
		if (TrouverNom == false) {
			System.err.println("Il n'existe pas de médicament à ce nom essayez à nouveau");	
			
			
			return lireMedicament();
			}
		return num;
	}
	
}
