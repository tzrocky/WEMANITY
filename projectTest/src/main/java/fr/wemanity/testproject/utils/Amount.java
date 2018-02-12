/**
 * 
 */
package fr.wemanity.testproject.utils;

import java.text.DecimalFormat;

/**
 * @author rtsane
 * 12-02-2018
*  Classe de gestion des montants du relevé bancaire
 *
 */
public class Amount {
	
	private DecimalFormat decimalFormat = new DecimalFormat("#.00");
	
	private int value;
	
	/**
	 * Constructeur par défaut
	 */
	public Amount(){
	}
	
	/**
	 * @param pValue
	 * Constructeur avec un montant en paramètre
	 */
	public Amount(int pValue){
		this.value=pValue;
	}
	
	/**
	 * @return
	 */
	public String castToAmountPattern(){
		return decimalFormat.format(value);
	}
	
	/**
	 * @param pValue
	 * @return
	 * 
	 * Méthode utilisé pour exposé la valeur du montant dans d'autres classes.
	 */
	public static Amount valueOfAmount(int pValue) {
		return new Amount(pValue);
	}
	
	public Amount addValueToAmount(Amount pValueToAdd){
		return valueOfAmount(this.value + pValueToAdd.value);
	}
	
	public String setValueToAmountFormat(){
		return decimalFormat.format(value);
	}
	
	public Amount removeValueToAmount(Amount pValueToAdd){
		return valueOfAmount(this.value - pValueToAdd.value);
	}
	
	public Amount getNegativeValueOfAmount(){
		return valueOfAmount(-value);
	}
	
	
	public int getValue(){
		return this.value ;
	}
	
	public Boolean estSuperieur(Amount pAmount2){
		return this.value > pAmount2.getValue() ;
	}

	@Override
	public boolean equals(Object pObjet) {
		Amount obj = (Amount) pObjet;
		if (value != obj.value)
			return false;
		return true;
	}
}
