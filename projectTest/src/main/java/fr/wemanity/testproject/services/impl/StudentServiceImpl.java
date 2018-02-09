package fr.wemanity.testproject.services.impl;

import java.util.Date;

import fr.wemanity.testproject.dao.StudentDAO;
import fr.wemanity.testproject.pojo.Student;
import fr.wemanity.testproject.services.StudentService;

/**
 * 
 * RTZ 
 * 09-02-2018 
 * Implémentation du Service dédiée à l'élève
 * 
 */
public class StudentServiceImpl implements StudentService {

	private StudentDAO eleveDAO;

	// Prototype méthode de création d'un élève
	public Student creerEleve() {
		return new Student();
	}

	// Prototype méthode d'enregistrement d'un élève
	public void enregistreEleve(Student pEleve) {
		pEleve.setDatEnreg(new Date());
		eleveDAO.save(pEleve);

	}

	public void setEleveDAO(StudentDAO pEleveDAO) {
		this.eleveDAO = pEleveDAO;
	}
}