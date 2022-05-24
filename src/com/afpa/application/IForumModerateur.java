package com.afpa.application;

interface IForumModerateur
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    String getNom ();

    void supprimerNouvelle ( Nouvelle nouvelle );

    void bannirUnAbonne ( Abonne abonne );

    int ajouterAbonne ( Abonne abonne );

    void listerAbonnes ();
}
