package fr.wemanity.testproject.utils;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rtsane
 * 12-02-2018
 * Classe de gestion de la Transaction
 *
 */
public class Transaction {

		private SimpleDateFormat df = new SimpleDateFormat(Constantes.FORMAT_DATE);
	
		private Amount value;
		private Date dateTransaction;
	
		public Transaction(Amount value, Date pDatTransaction) {
			this.value = value;
			this.dateTransaction = pDatTransaction;
		}
	
		/**
		 * @param pMontantTransaction
		 * @return
		 */
		public Amount getMontantTransaction(Amount pMontantTransaction) {
			return pMontantTransaction.addValueToAmount(value);
		}
		
		
		/**
		 * @param pTransactionBuilder
		 * @param pSoldeCourant
		 */
		private void addSoldeToBuilder(StringBuilder pTransactionBuilder, Amount pSoldeCourant) {
			pTransactionBuilder.append("| ")
				   .append(pSoldeCourant.setValueToAmountFormat());
		}
	
		/**
		 * @param pTransactionBuilder
		 * Méthode d'ajout du montant de la transaction dans le builder 
		 */
		private void ajoutMontantToBuilder(StringBuilder pTransactionBuilder) {
			if (value.estSuperieur(Amount.valueOfAmount(0))) {
				ajoutCreditToBuilder(pTransactionBuilder);
			} else {
				ajoutDebitToBuilder(pTransactionBuilder);
			}
		}
	
		/**
		 * @param pTransactionBuilder
		 * Méthode d'ajout du débit de la transaction dans le builder 
		 */
		private void ajoutDebitToBuilder(StringBuilder pTransactionBuilder) {
			pTransactionBuilder.append(Constantes.EMPTY_VALUE)
				   .append("|")
				   .append(printValue());
		}
	
		/**
		 * @param pTransactionBuilder
		 * Méthode d'ajout du crédit de la transaction dans le builder 
		 */
		private void ajoutCreditToBuilder(StringBuilder pTransactionBuilder) {
			pTransactionBuilder.append(printValue())
					.append("|")
					.append(Constantes.EMPTY_VALUE);
		}
	
		
		/**
		 * @param pTransactionBuilder
		 * Méthode d'ajout d'une date de la transaction dans le builder 
		 */
		private void ajoutDateToBuilder(StringBuilder pTransactionBuilder) {
			pTransactionBuilder.append(df.format(dateTransaction));
			pTransactionBuilder.append(Constantes.PIPE);
		}
		
		/**
		 * @param pPrinter
		 * @param pSolde
		 * Méthode de chargement d'une ligne du relevé bancaire
		 */
		public void chargerLigneEnreg(PrintStream pPrinter, Amount pSolde) {
			StringBuilder transactionBuilder = new StringBuilder();
			ajoutDateToBuilder(transactionBuilder);
			ajoutMontantToBuilder(transactionBuilder);
			addSoldeToBuilder(transactionBuilder, pSolde);
			pPrinter.println(transactionBuilder.toString());
		}
		
		/**
		 * @return
		 */
		public String printValue() {
			String stringValue = " " + value.setValueToAmountFormat();
			return stringValue;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 * Redéfinition de la méthode equals
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			Transaction other = (Transaction) obj;
			if (dateTransaction == null) {
				if (other.dateTransaction != null)
					return false;
			} else if (!dateTransaction.equals(other.dateTransaction))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
	
}

