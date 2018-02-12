package fr.wemanity.testproject.pojo;

import java.io.PrintStream;

import fr.wemanity.testproject.utils.Amount;
import fr.wemanity.testproject.utils.Transaction;

/**
 * @author rtsane
 * 12-02-2018
 * Classe de gestion des lignes du Relevé bancaire
 */
public class LigneReleve {

	private Transaction transaction;
	private Amount montantTransaction;

	/**
	 * @param pTransaction
	 * @param pMontantTransaction
	 */
	public LigneReleve(Transaction pTransaction, Amount pMontantTransaction) {
		this.transaction = pTransaction;
		this.montantTransaction = pMontantTransaction;
	}

	/**
	 * @param output
	 * Méthode d'impression d'une ligne du relevé bancaire
	 */
	public void printTo(PrintStream output) {
		this.transaction.chargerLigneEnreg(output, montantTransaction);
	}

}