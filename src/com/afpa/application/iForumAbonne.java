package com.afpa.application;

interface iForumAbonne
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    String getNom();

    int getIndex(Nouvelle n);

    boolean ajouterNouvelle(Nouvelle n);

    Nouvelle consulterNouvelle(int i);

    void repondreNouvelle(int i, Personne auteur);
}
