package com.intiformation.Exception;

public class nbMedicamentNegException extends Exception 
{

		public nbMedicamentNegException()
		{
			System.err.println("La valeur de la quantitée approvisionné doit être positive");
		}
}
