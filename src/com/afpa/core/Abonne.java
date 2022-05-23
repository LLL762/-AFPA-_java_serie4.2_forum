package com.afpa.core;

import com.afpa.outil.Grade;

public
class Abonne extends Personne
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    Forum forum;
    Grade grade;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
    Abonne(String prenom, String nom, int age)
    {
        super(prenom, nom, age);
        this.grade = Grade.ABONNE;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
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
                                 grade.toString(), forum.nom);
        }
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

}
