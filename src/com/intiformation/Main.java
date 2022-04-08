package com.intiformation;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
	static ArrayList<Client> ListeClient = new ArrayList<Client>();
	static ArrayList<Medicament> ListeMedicament = new ArrayList<Medicament>();
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
			System.out.println("Que voulez vous faire ? "
					+ "\n1 Afficher les informations d'un client ou d'un médicament"
					+ "\n2 Approvisionner"
					+ "\n3 Traiter un Achat"
					+ "\n4 Quitter");
		key = sc.nextInt();
		switch (key) {
		case 1 : 
			afficherInfos();
			
			break;
		case 2 : 
			approvisionner();
			
			break;
			
		case 3 : 
			achat();
			
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
		System.out.println("Quels informations voulez vous afficher ? \n1 : Client \n2 : Medicament");
		
		if(sc.nextInt()==1) 
		{
			lireClient ();
		}
		else
		{
			lireMedicament ();
		}
		
	}

	
	public static void approvisionner()
	
	{
		int num = lireMedicament();
		if (num != -1) {
			System.out.println("Quelle quantité voulez-vous approvisionner ?");
			ListeMedicament.get(num).setStock(sc.nextInt()+ListeMedicament.get(num).getStock());
			System.out.println("Voici les informations du médicament : " + ListeMedicament.get(num).getNom()+ "\n " + ListeMedicament.get(num));
		}

	}
	
	public static void achat()
	{
		int nume = lireClient ();
		if (nume != -1)
		{
	
		}
	}
	
	
	public static int lireClient ()
	{
		int nume =-1;
		System.out.println("Veuillez saisir le nom du client : ");
		String nom = sc.next();
		for(int i = 0; i < ListeClient.size(); i++)
		{
			boolean TrouverNom = false;
			if(ListeClient.get(i).getNom().contains(nom))
			{
				TrouverNom = true; 
				nume = i;
			System.out.println("Voici les information du client : " + nom + "\n " + ListeClient.get(i));	
			break;
			}
			
				System.err.println("Il n'existe pas de client à ce nom");
				break;
			
		}
		return nume;
	}
	
	public static int lireMedicament ()
	{
		int num =-1;
		System.out.println("Veuillez saisir le nom du médicament : ");
		String nom = sc.next();
		for(int i = 0; i < ListeMedicament.size(); i++)
		{
			boolean TrouverNom = false;
			if(ListeMedicament.get(i).getNom().contains(nom))
			{
				TrouverNom = true; 
				num = i;
				
			System.out.println("Voici les information du médicament : " + nom + "\n " + ListeMedicament.get(i));	
			break;
			}
			
				System.err.println("Il n'existe pas de médicament à ce nom");
				break;
			
		}
		return num;
	}
	
}
