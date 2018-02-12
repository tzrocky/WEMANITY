package fr.wemanity.testproject.services.impl;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import fr.wemanity.testproject.pojo.LigneReleve;
import fr.wemanity.testproject.services.ReleveService;
import fr.wemanity.testproject.utils.Amount;
import fr.wemanity.testproject.utils.Constantes;
import fr.wemanity.testproject.utils.Transaction;

/**
 * @author rtsane
 * 12-02-2018
 * Classe d'implémentation du service de gestion du relevé bancaire
 *
 */
public class ReleveServiceImpl implements ReleveService {

	private static final int TOP_OF_THE_LIST = 0;

	private List<LigneReleve> lignesReleve = new LinkedList<LigneReleve>();
	
	/* (non-Javadoc)
	 * @see fr.wemanity.testproject.services.ReleveService#addInfosLigneTransaction(fr.wemanity.testproject.utils.Transaction, fr.wemanity.testproject.utils.Amount)
	 */
	public void addInfosLigneTransaction(Transaction transaction, Amount soldeCourant) {
		lignesReleve.add(TOP_OF_THE_LIST, new LigneReleve(transaction, soldeCourant));
	}
	
	/* (non-Javadoc)
	 * @see fr.wemanity.testproject.services.ReleveService#print(java.io.PrintStream)
	 */
	public void print(PrintStream output) {
		output.println(Constantes.ENTETE_RELEVE);
		printLignesReleve(output);
	}

	/* (non-Javadoc)
	 * @see fr.wemanity.testproject.services.ReleveService#printLignesReleve(java.io.PrintStream)
	 */
	public void printLignesReleve(PrintStream output) {
		for (LigneReleve ligneReleve : lignesReleve) {
			ligneReleve.printTo(output);
		}
	}	
	

}