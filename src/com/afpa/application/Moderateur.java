package com.afpa.application;

import static com.afpa.outil.Grade.MODERATEUR;

class Moderateur extends UtilisateurForum {

	/* - - - - - - - - - - - - - - - */
	/* CONSTRUCTEUR */
	/* - - - - - - - - - - - - - - - */

	/**
	 * Constructeur de la classe modérateur. Initialise de base du modérateur avec
	 * un grade 'MODERATEUR'
	 *
	 * @param prenom Le prénom du modérateur
	 * @param nom    Le nom du modérateur
	 * @param age    L'age du modérateur
	 * @param forum  Le forum à assigner au moderateur
	 */
	public Moderateur(String prenom, String nom, int age, Forum forum) {

		super(prenom, nom, age, forum, MODERATEUR);

	}

	/* - - - - - - - - - - - - - - - */
	/* METHODES */
	/* - - - - - - - - - - - - - - - */

	/**
	 * Ajouter un abonné au forum du modérateur
	 *
	 * @param abonne L'abonné à ajouter au forum du modérateur
	 *
	 * @return L'index auquel se trouve l'abonné dans la liste de stockage. (-1 si
	 *         échec)
	 */
	public int ajouterAbonne(Abonne abonne) {

		return this.getForum() != null ? this.getForum().ajouterAbonne(abonne) : -1;

	}

	/**
	 * Avertir un abonné sur le forum du modérateur
	 *
	 * @param abonne L'abonné à avertir sur le forum du modérateur
	 */
	public void avertirAbonne(Abonne abonne) {

		if (this.getForum() != null) {
			this.getForum().avertirUnAbonne(abonne);
		}
	}

	/**
	 * Exclure un abonné du forum du modérateur
	 *
	 * @param abonne L'abonné à exclure au forum du modérateur
	 */
	public void exclureAbonne(Abonne abonne) {
		if (this.getForum() != null) {
			this.getForum().bannirUnAbonne(abonne);
		}
	}

	/**
	 * Supprimer une nouvelle du forum du modérateur
	 *
	 * @param nouvelle La nouvelle à supprimer du forum
	 */
	public void supprimerNouvelle(Nouvelle nouvelle) {
		if (this.getForum() != null) {
			this.getForum().supprimerNouvelle(nouvelle);
		}
	}

	/**
	 * Afficher une liste des abonnés
	 */
	public void afficherLesAbonnes() {
		if (this.getForum() != null) {
			this.getForum().listerAbonnes();
		}
	}
}
