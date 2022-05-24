package com.afpa.application;

interface iForumAbonne
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    String getNom ();

    int getIndex ( Nouvelle nouvelle );

    void ajouterNouvelle ( Nouvelle nouvelle );

    Nouvelle consulterNouvelle ( int index );

    void repondreNouvelle ( int index, Personne auteur );
}
