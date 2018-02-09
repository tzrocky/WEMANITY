package fr.wemanity.testproject.services;

import fr.wemanity.testproject.pojo.Student;

/**
 * 
 * RTZ 
 * 09-02-2018 
 * Service dédiée à l'élève
 * 
 */
public interface StudentService {

	// Prototype méthode de création d'un élève
	public Student creerEleve();
	// Prototype méthode d'enregistrement d'un élève
	public void enregistreEleve(Student pEleve);
}