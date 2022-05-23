package com.afpa.application;

import com.afpa.outil.Grade;

class Moderateur extends Personne
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    iForumModerateur forum;
    Grade grade;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    // Implémentation du constructeur possible sans forum, actuellement non utilisée
    /*
    protected
    Moderateur(String prenom, String nom, int age)
    {
        super(prenom, nom, age);
        this.forum = null;
        this.grade = Grade.MODERATEUR;
    }
    */
    protected
    Moderateur( String prenom, String nom, int age, Forum forum )
    {
        super( prenom, nom, age );
        setForum( forum );
        this.grade = Grade.MODERATEUR;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    protected
    void setForum( Forum forum )
    {
        this.forum = forum;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                    REDEFINITION DE TOSTRING()                */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @Override
    public
    String toString( )
    {
        if ( this.forum == null )
        {
            return String.format( "Je suis %s %s. J'ai %d et je suis %s et je n'ai pas de forum.", prenom, nom, age,
                                  grade.toString() );
        }
        else
        {
            return String.format( "Je suis %s %s. J'ai %d et je suis %s sur le forum %s.", prenom, nom, age,
                                  grade.toString(), forum.getNom() );
        }
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    protected
    int ajouterAbonne( Abonne a )
    {
        return forum.ajouterAbonne( a );
    }

    protected
    void exclureAbonne( Abonne a )
    {
        forum.bannirUnAbonne( a );
    }

    protected
    void supprimerNouvelle( Nouvelle n )
    {
        forum.supprimerNouvelle( n );
    }

    protected
    void afficherLesAbonnes()
    {
        forum.listerAbonnes();
    }
}
