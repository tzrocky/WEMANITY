/**
 * 
 */
package fr.wenanity.testproject.projectTest;

import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.wemanity.testproject.buliders.TransactionBuilder;
import fr.wemanity.testproject.pojo.Account;
import fr.wemanity.testproject.services.ReleveService;
import fr.wemanity.testproject.utils.Amount;
import fr.wemanity.testproject.utils.Constantes;

/**
 * @author rtsane
 * 12-02-2018
 * Classe de tests fonctionnelles (à partir de Mockito) des opérations sur le compte
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
	@Mock
	private static ReleveService releve;	//Les tests fonctionnels sont encapsulés dans le Relevé du compte
	private static Account account;

	// Avant tout initialiser le compte
	@Before
	public void initialise() {
		account = new Account(releve);
	}

	/**
	 * Test effectué un dépôt de 10000 euros
	 */
	@Test
	public void addDepositToReleve() {
		Date dateDepot;
		try {
			dateDepot = new SimpleDateFormat(Constantes.FORMAT_DATE).parse("30/01/2018");
			Amount montantDepot = Amount.valueOfAmount(10000);  // Faire un dépôt de 1000 euros
			account.deposit(montantDepot, dateDepot);
			verify(releve).addInfosLigneTransaction(TransactionBuilder.aTransaction().surDate(dateDepot).with(montantDepot).build(),
					egalAuSoldeCourant(montantDepot));
		} catch (ParseException e) {
			 System.err.println("In catch ParseException "+e.getClass() + "--- : " + e.getMessage());
		}
	}

	/**
	 * Test effectué un retrait de 500 euros
	 */
	@Test
	public void addWithdrawToReleve() {
		Date dateRetrait;
		try {
			dateRetrait = new SimpleDateFormat(Constantes.FORMAT_DATE).parse("30/01/2018");
			account.withdrawal(Amount.valueOfAmount(500), dateRetrait); // Dans le même contexte du premier test faire un retrait de 1000 euros
			verify(releve).addInfosLigneTransaction(
					TransactionBuilder.aTransaction().with(Amount.valueOfAmount(-500)).surDate(dateRetrait).build(),
					Amount.valueOfAmount(9500));
		}catch (ParseException e) {
			 System.err.println("In catch ParseException "+e.getClass() + "--- : " + e.getMessage());
		}
	}

	/**
	 * @param pMontant
	 * @return
	 */
	private Amount egalAuSoldeCourant(Amount pMontant) {
		return pMontant;
	}
	
	/**
	 * Test afficher le relevé
	 */
	@Test 
	public void afficheReleve() {
		PrintStream printer = System.out;
		account.printReleve(printer); // affiche le Relevé		
		verify(releve).print(printer); // Vérifie si l'affichage est OK.
	}

}
