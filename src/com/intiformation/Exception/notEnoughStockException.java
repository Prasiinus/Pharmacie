package com.intiformation.Exception;


public class notEnoughStockException extends Exception
{
	public notEnoughStockException()
	
	{
		System.err.println("Il n'y a pas assez de stock");
	}
}
