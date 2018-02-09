package fr.wenanity.testproject.projectTest;

import org.junit.Test;
import org.mockito.Mockito;

import fr.wemanity.testproject.dao.StudentDAO;
import fr.wemanity.testproject.pojo.Student;
import fr.wemanity.testproject.services.StudentService;
import fr.wemanity.testproject.services.impl.StudentServiceImpl;
import junit.framework.TestCase;

/**
 * 
 * RTZ 
 * 09-02-2018 
 * Classe de test de création d'un nouveau étudiant
 * 
 */
public class CreationStudentTest extends TestCase {

	/**
	 * TEST VALUE FOR ELEVE Nom : TSANE Prénom : Rocky Adresse : 39 rue de la
	 * fosse rouge, 94370 Sucy-en-brie
	 */

	public final static String NOM = "TSANE";
	public final static String PRENOM = "Rocky";
	public final static String ADRESSE = "39 rue de la fosse rouge, 94370 Sucy-en-brie";

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public CreationStudentTest(String testName) {
		super(testName);
	}

	@Test
	public void testCreationEleve() {
		// Service dédié à l'élève
		StudentService eleveService = new StudentServiceImpl();
		// Création de l'élève
		Student eleve = eleveService.creerEleve();
		// Test si l'lève est bien créé
		assertNotNull(eleve);
	}

	@Test
	public void testEnregistrementEleve() {
		// Enregistrement des données de l'élève
		Student eleve = new Student();
		eleve.setNom(NOM);
		eleve.setPrenom(PRENOM);
		eleve.setAdresse(ADRESSE);

		StudentServiceImpl eleveServiceImpl = new StudentServiceImpl();
		StudentService eleveService = eleveServiceImpl;

		// Encapsule les comportements de l'élève dans le Mock
		StudentDAO eleveDAO = Mockito.mock(StudentDAO.class);
		eleveServiceImpl.setEleveDAO(eleveDAO);

		// Enregistrement de l'éléève
		eleveService.enregistreEleve(eleve);

		// Vérifier que la date d'enregistrement est non null
		assertNotNull(eleve.getDatEnreg());
		Mockito.verify(eleveDAO).save(eleve);

		assertEquals("TSANE", eleve.getNom());
		assertEquals("Rocky", eleve.getPrenom());
		assertEquals("39 rue de la fosse rouge, 94370 Sucy-en-brie", eleve.getAdresse());
	}
}
