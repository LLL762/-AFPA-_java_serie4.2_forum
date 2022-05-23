package com.afpa.core;

public
interface iModerateurForum
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    boolean supprimerNouvelle(Nouvelle n);

    void bannirUnAbonne(Abonne a);

    int ajouterAbonne(Abonne a);

    void listerAbonnes();
}
