package com.afpa.application;

import com.afpa.core.Abonne;
import com.afpa.core.Forum;
import com.afpa.core.Moderateur;
import com.afpa.core.Personne;

import static com.afpa.outil.Affichage.informativeWindow;

public
class Main
{
    public static
    void main(String[] args)
    {
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        // Instanciation forum
        Forum forum = new Forum("Spread-it");

        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        // Instanciation abonnés
        Abonne jean    = new Abonne("Jean", "Steam", 31);
        Abonne pierre  = new Abonne("Pierre", "Upright", 28);
        Abonne patrick = new Abonne("Patrick", "Regular", 38);
        Abonne mickael = new Abonne("Mickael", "Operate", 23);
        Abonne ibrahim = new Abonne("Ibrahim", "Disagree", 29);

        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        // Instanciation modérateur

        /*
        Moderateur john = new Moderateur("John", "Do", 31);

        informativeWindow(john.toString(), "test_modo");
        john.setForum(forum);
        informativeWindow(john.toString(), "test_modo");
        */

    }
}