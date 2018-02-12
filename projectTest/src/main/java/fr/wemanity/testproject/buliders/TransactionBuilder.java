package fr.wemanity.testproject.buliders;

import java.util.Date;

import fr.wemanity.testproject.utils.Amount;
import fr.wemanity.testproject.utils.Transaction;

/**
 * @author rtsane
 * 12-02-2018
 * Classe implémentation du Pattern Builder des transactions
 */
public class TransactionBuilder {
	
	private Date date;
	private Amount value;

	/**
	 * @return
	 */
	public static TransactionBuilder aTransaction() {
		return new TransactionBuilder();
	}

	/**
	 * @param date
	 * @return
	 */
	public TransactionBuilder surDate(Date date) {
		this.date = date;
		return this;
	}

	/**
	 * @param value
	 * @return
	 */
	public TransactionBuilder with(Amount value) {
		this.value = value;
		return this;
	}

	/**
	 * @return
	 */
	public Transaction build() {
		Transaction transaction = new Transaction(value, date);
		return transaction;
	}
	
	

}