package com.afpa.application;

import com.afpa.outil.Grade;

import static com.afpa.outil.Affichage.informativeWindow;
import static com.afpa.outil.Affichage.questionWindow;
class Abonne extends Personne
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    iForumAbonne forum;
    private final Grade grade;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    protected
    Abonne(String prenom, String nom, int age)
    {
        super(prenom, nom, age);
        this.forum = null;
        this.grade = Grade.ABONNE;
    }

    // Implémentation du constructeur possible avec un forum, actuellement non utilisée
    /*
    protected
    Abonne(String prenom, String nom, int age, Forum forum)
    {
        super(prenom, nom, age);
        setForum(forum);
        this.grade = Grade.ABONNE;
    }
    */

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    void setForum(Forum forum)
    {
        this.forum = forum;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                    REDEFINITION DE TOSTRING()                */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @Override
    public
    String toString()
    {
        if (this.forum == null)
        {
            return String.format("Je suis %s %s. J'ai %d et je suis %s et je n'ai pas de forum.", prenom, nom, age,
                                 grade.toString());
        }
        else
        {
            return String.format("Je suis %s %s. J'ai %d et je suis %s sur le forum %s.", prenom, nom, age,
                                 grade.toString(), forum.getNom());
        }
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    // Possibilité de creer une nouvelle via une GUI, actuellement non utilisée
    /*
    protected
    Nouvelle creerNouvelleGUI()
    {
        return new Nouvelle(questionWindow("Entrer le titre de votre nouvelle", "titre_nouvelle"),
                                  questionWindow("Entrer le texte de votre nouvelle", "texte_nouvelle"), this);
    }
    */
    protected
    Nouvelle creerNouvelle(String titre, String texte)
    {
        return new Nouvelle(titre, texte, this);
    }

    protected
    void deposerNouvelle(Nouvelle n)
    {
        if (this.forum != null)
        {
            forum.ajouterNouvelle(n);
        }
    }

    protected
    void lireNouvelle(int i)
    {
        if (this.forum != null)
        {
            informativeWindow(forum.consulterNouvelle(i).toString(), String.format("article n°%d%n", i));
        }
    }

    protected
    void repondreNouvelle(Nouvelle nvl)
    {
        if (this.forum != null)
        {
            int index = forum.getIndex(nvl);
            forum.repondreNouvelle(index, this);
        }
    }
}
