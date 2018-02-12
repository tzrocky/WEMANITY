package fr.wenanity.testproject.projectTest;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import fr.wemanity.testproject.utils.Amount;

public class TestMontant {
	
	/**
	 *  Check is same amounts
	 */
	@Test 
	public void	haveSameAmount () {
		Amount deuxMilles = new Amount(2000);
		Amount varAComparer = new Amount(2000);
		
		assertThat(deuxMilles, is(equalTo(varAComparer)));
	}

	/**
	 *  Check is different amounts
	 */
	@Test 
	public void	haveDifferentAmount() {
		Amount ten = new Amount(10);
		Amount five = new Amount(5);
		
		assertThat(ten, is(not(equalTo(five))));
	}
	
	
	/**
	 *  Check is the value of sum of two amounts
	 */
	@Test public void
	should_sum_up_amounts() {
		Amount fifty = Amount.valueOfAmount(50);
		Amount eight = Amount.valueOfAmount(8);
		Amount fiftyEigth = Amount.valueOfAmount(58);
		
		assertThat(fiftyEigth, is(equalTo(fifty.addValueToAmount(eight))));
	}
	
	@Test 
	public void	montantSuperieur() {
		Amount ten = Amount.valueOfAmount(10);
		Amount five = Amount.valueOfAmount(5);
		
		assertThat(ten.estSuperieur(five), is(true));
	}
	
	@Test public void
	should_indicate_when_it_is_not_greater_than_other_amount() {
		Amount ten = Amount.valueOfAmount(10);
		Amount five = Amount.valueOfAmount(5);
		
		assertThat(five.estSuperieur(ten), is(false));
	}
	
	@Test 
	public void	getNegativeValue() {
		Amount five = Amount.valueOfAmount(5);
		
		assertThat(Amount.valueOfAmount(-5), is(equalTo(five.getNegativeValueOfAmount())));
	}
	
	@Test public void
	should_return_money_representation() {
		Amount oneThousand = Amount.valueOfAmount(1000);
		
		assertThat("1000,00", is(equalTo(oneThousand.castToAmountPattern())));
	}
	
}