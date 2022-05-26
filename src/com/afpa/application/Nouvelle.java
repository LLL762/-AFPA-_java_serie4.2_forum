package com.afpa.application;

import java.util.Date;

class Nouvelle {
	/* - - - - - - - - - - - - - - - */
	/* VARIABLES */
	/* - - - - - - - - - - - - - - - */

	private String sujet;
	private String texte;
	private Date dateCreation;

	private Personne auteur;

	/* - - - - - - - - - - - - - - - */
	/* CONSTRUCTEUR */
	/* - - - - - - - - - - - - - - - */

	/**
	 * Constructeur de la classe nouvelle
	 *
	 * @param sujet  Le sujet de la nouvelle
	 * @param texte  Le contenu de la nouvelle
	 * @param auteur L'auteur de la nouvelle
	 */
	protected Nouvelle(String sujet, String texte, Personne auteur) {
		this.sujet = sujet;
		this.texte = texte;
		this.auteur = auteur;
		this.dateCreation = new Date();
	}

	/* - - - - - - - - - - - - - - - */
	/* GETTER / SETTER */
	/* - - - - - - - - - - - - - - - */

	public Date getDateCreation() {
		return dateCreation;
	}

	public String getSujet() {
		return sujet;
	}

	/* - - - - - - - - - - - - - - - */
	/* REDEFINITION DE TOSTRING() */
	/* - - - - - - - - - - - - - - - */

	/**
	 * Redefinition de toString()
	 *
	 * @return Une présentation de la nouvelle avec titre / contenu / auteur
	 */
	@Override
	public String toString() {
		return String.format("-------------------%ntitre : '%s'%nnouvelle : %s%nauteur : %s%n-------------------%n",
				sujet, texte, auteur.toStringShort());
	}

	/* - - - - - - - - - - - - - - - */
	/* METHODES */
	/* - - - - - - - - - - - - - - - */
}
