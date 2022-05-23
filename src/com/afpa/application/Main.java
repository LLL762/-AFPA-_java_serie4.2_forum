package com.afpa.application;

import com.afpa.core.Abonne;
import com.afpa.core.Forum;
import com.afpa.core.Moderateur;
import com.afpa.core.Nouvelle;

import static com.afpa.outil.Affichage.informativeWindow;

public
class Main
{
    public static
    void main(String[] args)
    {
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        // Instanciation forum

        //Forum forum = new Forum(questionWindow("Entrer le nom du forum", "forum_name_request"));
        Forum forum = new Forum("$pread-it");

        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        // Instanciation abonnés
        Abonne jean    = new Abonne("Jean", "Steam", 31);
        Abonne pierre  = new Abonne("Pierre", "Upright", 28);
        Abonne patrick = new Abonne("Patrick", "Regular", 38);
        Abonne mickael = new Abonne("Mickael", "Operate", 23);
        Abonne ibrahim = new Abonne("Ibrahim", "Disagree", 29);
        informativeWindow(jean.toString(), "test_abo");

        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        // Instanciation modérateur
        Moderateur john = new Moderateur("John", "Do", 31, forum);
        informativeWindow(john.toString(), "test_modo");

        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        // Ajout des abonnées au forum par le modo + affichage
        john.ajouterAbonne(jean);
        john.ajouterAbonne(pierre);
        john.ajouterAbonne(patrick);
        john.ajouterAbonne(mickael);
        john.ajouterAbonne(ibrahim);

        john.afficherLesAbonnes();

        Nouvelle n1 = jean.creerNouvelle("Ago Yesterday Not", "Perform, Could, Educate, Favor, Rust");
        jean.deposerNouvelle(n1);
        Nouvelle n2 = pierre.creerNouvelle("SandMountain Elastic", "Earth, Kill, Star, Escape, Cut");
        pierre.deposerNouvelle(n2);
        Nouvelle n3 = pierre.creerNouvelle("Someone Fate", "Chalk, Hammer, Work, Father, Bit, Spread");
        pierre.deposerNouvelle(n3);
        Nouvelle n4 = patrick.creerNouvelle("Sheep Kitchen", "These, Knowledge, Effort, Nephew, Food, Cloth");
        patrick.deposerNouvelle(n4);
        Nouvelle n5 = ibrahim.creerNouvelle("Along Nut", "Nurse, Valuable, Speech, Any, Clock, Write");
        ibrahim.deposerNouvelle(n5);


        mickael.lireNouvelle(2);
        mickael.repondreNouvelle(n3);

        pierre.lireNouvelle(4);
        pierre.repondreNouvelle(n5);

        /* Ne marche pas :

                pierre.ajouterAbonne(ibrahim);
                john. lireNouvelle(2);

         */



        forum.listerMessages();

        informativeWindow(forum.toString(), "info_forum");

    }
}