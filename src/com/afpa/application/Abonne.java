package com.afpa.application;

import com.afpa.outil.Grade;

import static com.afpa.outil.Affichage.informativeWindow;

class Abonne extends Personne
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    IForumAbonne forum;
    Grade grade;
    int avertissement;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur de la classe abonné.
     * Initialise de base l'abonne avec un forum 'null' et un grade 'ABONNE'
     *
     * @param prenom Le prénom à assigner à l'abonné
     * @param nom    Le nom à assigner à l'abonné
     * @param age    L'âge à assigner à l'abonné
     */
    protected
    Abonne ( String prenom, String nom, int age )
    {
        super ( prenom, nom, age );
        this.forum         = null;
        this.grade         = Grade.ABONNE;
        this.avertissement = 0;

    }

    /*
     *  Implémentation du constructeur possible avec un forum, actuellement non utilisée
     *
     * @param prenom Le prénom à assigner à l'abonné
     * @param nom    Le nom à assigner à l'abonné
     * @param age    L'âge à assigner à l'abonné
     * @param forum  Objet de type forum pour l'assigner directement
     *
     * @deprecated
     *
     *     protected
     *     Abonne(String prenom, String nom, int age, Forum forum)
     *     {
     *         super(prenom, nom, age);
     *         setForum(forum);
     *         this.grade = Grade.ABONNE;
     *     }
     */

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Setter pour assigner un forum à l'abonné
     *
     * @param forum Le forum à assigner à l'objet abonné
     */
    protected
    void setForum ( Forum forum )
    {
        this.forum = forum;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                    REDEFINITION DE TOSTRING()                */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Redefinition de toString()
     *
     * @return Une présentation de l'abonné sous forme de String
     */
    @Override
    public
    String toString ()
    {
        if ( this.forum == null )
        {
            return String.format ( "Je suis %s %s. J'ai %d et je suis %s et je n'ai pas de forum.", prenom, nom, age,
                                   grade.toString () );
        }
        else
        {
            return String.format ( "Je suis %s %s. J'ai %d et je suis %s sur le forum %s.", prenom, nom, age,
                                   grade.toString (), forum.getNom () );
        }
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /*  Possibilité de creer une nouvelle via une GUI, actuellement non utilisée
     *
     * @return
     *
     * @deprecated
     *
     *     protected
     *     Nouvelle creerNouvelleGUI()
     *     {
     *         return new Nouvelle(questionWindow("Entrer le titre de votre nouvelle", "titre_nouvelle"),
     *                                   questionWindow("Entrer le texte de votre nouvelle", "texte_nouvelle"), this);
     *     }
     */

    /**
     * Creer une nouvelle, utilise le constructeur de la classe Nouvelle
     *
     * @param titre Le titre de la nouvelle
     * @param texte Le contenu de la nouvelle
     * @return
     */
    protected
    Nouvelle creerNouvelle ( String titre, String texte )
    {
        return new Nouvelle ( titre, texte, this );
    }

    /**
     * Déposer une nouvelle sur le forum
     *
     * @param nouvelle La nouvelle à ajouter au forum
     */
    protected
    void deposerNouvelle ( Nouvelle nouvelle )
    {
        if ( this.forum != null )
        {
            forum.ajouterNouvelle ( nouvelle );
        }
    }

    /**
     * Lire la nouvelle situé à 'index' dans le forum.( Créé une fenetre )
     *
     * @param index
     */
    protected
    void lireNouvelle ( int index )
    {
        if ( this.forum != null )
        {
            informativeWindow ( forum.consulterNouvelle ( index ).toString (),
                                String.format ( "article n°%d%n", index ) );
        }
    }

    /**
     * Répondre à une nouvelle. Pour cela, on question le forum pour avoir l'index de celle ci
     *
     * @param nouvelle La nouvelle à laquel on souhaite répondre
     */
    protected
    void repondreNouvelle ( Nouvelle nouvelle )
    {
        if ( this.forum != null )
        {
            int index = forum.getIndex ( nouvelle );
            forum.repondreNouvelle ( index, this );
        }
    }
}
