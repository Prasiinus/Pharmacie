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
		
		System.out.println("Que voulez vous faire ? "
				+ "\n1 Afficher les informations d'un client ou d'un médicament"
				+ "\n2 Approvisionner"
				+ "\n3 Traiter un Achat"
				+ "\n4 Quitter");
		
	
		int key = sc.nextInt();
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
//			lireMedicament
			System.out.println();
		}
		
	}

	
	public static void approvisionner()
	{
		
	}
	
	public static void achat()
	{
		
	}
	
	
	public static void lireClient ()
	{
		System.out.println("Veuillez saisir le nom du client : ");
		String nom = sc.next();
		for(int i = 0; i < ListeClient.size(); i++)
		{
			if(ListeClient.get(i).getNom() == nom)
			{
			System.out.println("Voici les information du client : " + nom + "\n " + ListeClient.get(i));	
			}
		}
		
	}
	
}
