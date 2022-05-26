package com.afpa.application;

import com.afpa.outil.Grade;

public abstract class UtilisateurForum extends Personne {

	private Forum forum;
	private Grade grade; // final?

	protected UtilisateurForum(String prenom, String nom, int age, Forum forum, Grade grade) {
		super(prenom, nom, age);
		this.forum = forum;
		this.grade = grade;

	}

	/* - - - - - - - - - - - - - - - */
	/* GETTER / SETTER */
	/* - - - - - - - - - - - - - - - */

	public Grade getGrade() {
		return grade;
	}

	public Forum getForum() {
		return forum;
	}

	/**
	 * Setter pour assigner un forum à l'abonné
	 *
	 * @param forum Le forum à assigner à l'objet modérateur
	 */
	public void setForum(Forum forum) {
		this.forum = forum;
	}

	/* - - - - - - - - - - - - - - - */
	/* REDEFINITION DE TOSTRING() */
	/* - - - - - - - - - - - - - - - */

	/**
	 *
	 *
	 * Redefinition de toString()
	 *
	 * @return Une présentation du modérateur sous forme de String
	 */

	@Override
	public String toString() {

		final String superMinusLastChar = super.toString().substring(0, super.toString().length() - 1);

		if (this.forum == null) {
			return superMinusLastChar
					+ String.format(" et je suis %s et je n'ai pas de forum.", grade.toString());
		}

		return superMinusLastChar
				+ String.format(" et je suis %s sur le forum %s.", grade.toString(), forum.getNom());

	}

}
