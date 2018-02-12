/**
 * 
 */
package fr.wemanity.testproject.pojo;

import java.io.PrintStream;
import java.util.Date;

import fr.wemanity.testproject.services.ReleveService;
import fr.wemanity.testproject.utils.Amount;
import fr.wemanity.testproject.utils.Transaction;

/**
 * @author rtsane
 * 12-02-2018
 * Classe de gestion des operations sur le compte bancaire
 */
public class Account {
private ReleveService releve = new ReleveServiceImpl();
	
	private static Amount solde = new Amount();


	/**
	 * @param pReleve
	 * Constructeur du compte avec en paramètre le service Relevé
	 */
	public Account(ReleveService pReleve) {
		this.releve = pReleve;
		solde = solde.addValueToAmount(Amount.valueOfAmount(0));
	}

	/**
	 * @param value
	 * @param date
	 * Méthode de crédit d'un montant à une date dans le compte
	 */
	public void deposit(Amount value, Date date) {
		enregTransaction(value, date);
	} 

	/**
	 * @param value
	 * @param date
	 * Méthode de débit d'un montant à une date dans le compte
	 */
	public void withdrawal(Amount value, Date date) {
		enregTransaction(value.getNegativeValueOfAmount(), date);
	}

	/**
	 * @param printer
	 * Méthode d'impression du Relevé du compte
	 */
	public void printReleve(PrintStream printer) {
		releve.print(printer);
	}

	/**
	 * @param value
	 * @param date
	 * Méthode d'enregistrement d'une transaction dans le compte
	 */
	public void enregTransaction(Amount value, Date date) {
		Transaction transaction = new Transaction(value, date);
		Amount soldeTransaction = transaction.getMontantTransaction(solde);
		solde = soldeTransaction;
		releve.addInfosLigneTransaction(transaction, soldeTransaction);
	}
}
