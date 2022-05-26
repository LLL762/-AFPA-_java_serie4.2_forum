package com.afpa.application;

abstract class Personne {
	/* - - - - - - - - - - - - - - - */
	/* VARIABLES */
	/* - - - - - - - - - - - - - - - */

	private String prenom; // final?
	private String nom; // final?
	private int age;

	/* - - - - - - - - - - - - - - - */
	/* CONSTRUCTEUR */
	/* - - - - - - - - - - - - - - - */

	/**
	 * Constructeur de la classe ABSTRAITE personne
	 *
	 * @param prenom Le prénom à assigner à la personne
	 * @param nom    Le nom à assigner à la personne
	 * @param age    L'âge à assigner à la personne
	 */
	protected Personne(String prenom, String nom, int age) {
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}

	/* - - - - - - - - - - - - - - - */
	/* GETTER / SETTER */
	/* - - - - - - - - - - - - - - - */

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public int getAge() {
		return age;
	}

	/* - - - - - - - - - - - - - - - */
	/* REDEFINITION DE TOSTRING() */
	/* - - - - - - - - - - - - - - - */

	/**
	 * Redefinition de toString()
	 *
	 * @return Une présentation de la personne sous forme de String
	 */
	@Override
	public String toString() {
		return String.format("Je suis %s %s. J'ai %d.", prenom, nom, age);
	}

	/**
	 * Redefinition de toString() mais en plus court, n'affichant que nom et prénom
	 *
	 * @return Une présentation courte de la personne sous forme de String
	 */
	public String toStringShort() {
		return String.format("%s %s", prenom, nom);
	}

	/* - - - - - - - - - - - - - - - */
	/* METHODES */
	/* - - - - - - - - - - - - - - - */
}
