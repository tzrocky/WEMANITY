package fr.wemanity.testproject.pojo;

import java.util.Date;

public class Student {
	
	private String nom;
	 private String prenom;
	 private String adresse;
	 private Date datEnreg;
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the datEnreg
	 */
	public Date getDatEnreg() {
		return datEnreg;
	}
	/**
	 * @param datEnreg the datEnreg to set
	 */
	public void setDatEnreg(Date datEnreg) {
		this.datEnreg = datEnreg;
	}
	 
	 
}