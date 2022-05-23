package com.afpa.application;

import java.util.Date;

class Nouvelle
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    String sujet;
    String texte;
    Date dateCreation;
    Personne auteur;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    protected
    Nouvelle(String sujet, String texte, Personne auteur)
    {
        this.sujet        = sujet;
        this.texte        = texte;
        this.auteur       = auteur;
        this.dateCreation = new Date();
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                    REDEFINITION DE TOSTRING()                */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @Override
    public
    String toString()
    {
        return String.format("-------------------%ntitre : '%s'%nnouvelle : %s%nauteur : %s%n-------------------%n",
                             sujet, texte, auteur.toStringMetadata());
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
}
