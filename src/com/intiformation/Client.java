package com.intiformation;
import java.util.Scanner;
public class Client {
	static Scanner sc = new Scanner(System.in);
	//Attributs
	private String nom;
	private double credit;
	
	
	
	public Client() {
		super();
	}



	public Client(String nom, double credit) {
		super();
		this.nom = nom;
		this.credit = credit;
	}


	
	
	
	
	
	
	

	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public double getCredit() {
		return credit;
	}



	public void setCredit(double credit) {
		this.credit = credit;
	}



	@Override
	public String toString() {
		return "Client [nom=" + nom + ", credit=" + credit + "]";
	}
	
	
	
}
