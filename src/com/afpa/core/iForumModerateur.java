package com.afpa.core;

public
interface iForumModerateur
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    String getNom();

    boolean supprimerNouvelle(Nouvelle n);

    void bannirUnAbonne(Abonne a);

    int ajouterAbonne(Abonne a);

    void listerAbonnes();
}
