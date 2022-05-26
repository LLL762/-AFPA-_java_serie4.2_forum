package com.afpa.application;

import static com.afpa.outil.Affichage.informativeWindow;
import static com.afpa.outil.Grade.ABONNE;

class Abonne extends UtilisateurForum {
	/* - - - - - - - - - - - - - - - */
	/* VARIABLES */
	/* - - - - - - - - - - - - - - - */

	private int avertissement = 0;

	/* - - - - - - - - - - - - - - - */
	/* CONSTRUCTEUR */
	/* - - - - - - - - - - - - - - - */

	/**
	 * Constructeur de la classe abonné. Initialise de base l'abonne avec un forum
	 * 'null' et un grade 'ABONNE'
	 *
	 * @param prenom Le prénom à assigner à l'abonné
	 * @param nom    Le nom à assigner à l'abonné
	 * @param age    L'âge à assigner à l'abonné
	 */
	public Abonne(String prenom, String nom, int age) {
		super(prenom, nom, age, null, ABONNE);

	}

	public int getAvertissement() {
		return avertissement;
	}

	public void setAvertissement(int avertissement) {
		this.avertissement = avertissement;
	}

	/* - - - - - - - - - - - - - - - */
	/* METHODES */
	/* - - - - - - - - - - - - - - - */

	/*
	 * Possibilité de créer une nouvelle via une GUI, actuellement non utilisée
	 *
	 * @return
	 *
	 * @deprecated
	 *
	 * protected Nouvelle creerNouvelleGUI() { return new
	 * Nouvelle(questionWindow("Entrer le titre de votre nouvelle",
	 * "titre_nouvelle"), questionWindow("Entrer le texte de votre nouvelle",
	 * "texte_nouvelle"), this); }
	 */

	/**
	 * Créer une nouvelle, utilise le constructeur de la classe Nouvelle
	 *
	 * @param titre Le titre de la nouvelle
	 * @param texte Le contenu de la nouvelle
	 *
	 * @return La nouvelle ici créée
	 */
	protected Nouvelle creerNouvelle(String titre, String texte) {
		return new Nouvelle(titre, texte, this);

	}

	/**
	 * Déposer une nouvelle sur le forum
	 *
	 * @param nouvelle La nouvelle à ajouter au forum
	 */
	public void deposerNouvelle(Nouvelle nouvelle) {
		if (this.getForum() != null) {
			this.getForum().ajouterNouvelle(nouvelle);
		}
	}

	/**
	 * Lire la nouvelle située à 'index' dans le forum.(Créé une fenêtre)
	 *
	 * @param index L'index de l'élément dans la liste que l'on veut récupérer
	 */
	public void lireNouvelle(int index) {
		if (this.getForum() != null) {
			informativeWindow(this.getForum().consulterNouvelle(index).toString(),
					String.format("article n°%d%n", index));
		}
	}

	/**
	 * Répondre à une nouvelle. Pour cela, on questionne le forum pour avoir
	 * l'index de celle ci
	 *
	 * @param nouvelle La nouvelle à laquelle on souhaite répondre
	 */
	public void repondreNouvelle(Nouvelle nouvelle) {
		if (this.getForum() != null) {
			int index = this.getForum().getIndex(nouvelle);
			this.getForum().repondreNouvelle(index, this);
		}
	}
}
