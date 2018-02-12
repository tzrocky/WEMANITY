package fr.wemanity.testproject.services;

import java.io.PrintStream;

import fr.wemanity.testproject.utils.Amount;
import fr.wemanity.testproject.utils.Transaction;

/**
 * @author rtsane
 * 12-02-2018
 * Interface de gestion du service Relevé bancaire
 *
 */
public interface ReleveService {
	
	/**
	 * @param transaction
	 * @param soldeCourant
	 */
	public void addInfosLigneTransaction(Transaction transaction, Amount soldeCourant) ;
	
	/**
	 * @param output
	 */
	public void print(PrintStream output) ;

	/**
	 * @param output
	 */
	public void printLignesReleve(PrintStream output);
	

}