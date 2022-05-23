package com.afpa.core;

import java.util.ArrayList;
import java.util.Date;

import static com.afpa.outil.Affichage.informativeWindow;
import static com.afpa.outil.Affichage.questionWindow;

public
class Forum implements iAbonneForum, iModerateurForum
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    String nom;
    Date dateCreation;

    ArrayList<Nouvelle> listNouvelle = new ArrayList<>();
    ArrayList<Abonne> listAbonne = new ArrayList<>();

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
    Forum(String nom)
    {
        setNom(nom);
        this.dateCreation = new Date();
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
    void setNom(String nom)
    {
        if (!(nom.equals("")))
        {
            this.nom = nom.trim().toUpperCase();
        }
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                    REDEFINITION DE TOSTRING()                */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @Override
    public
    String toString()
    {
        return String.format("Le forum '%s' a été créé le '%2$td %2$tB, %2$tY'%n", nom, dateCreation);
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    // Implémentation abonnés

    @Override
    public
    boolean ajouterNouvelle(Nouvelle n)
    {
        return this.listNouvelle.add(n);
    }

    @Override
    public
    void consulterNouvelle(int i)
    {
        informativeWindow(this.listNouvelle.get(i).toString(), String.format("article num %s%n", i));
    }

    @Override
    public
    void repondreNouvelle(int i)
    {
        new Nouvelle(this.listNouvelle.get(i).sujet, questionWindow(
                String.format("Entrer votre réponse au sujet '%s'.", this.listNouvelle.get(i).sujet), "Réponse"));
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    // Implémentation modérateur

    @Override
    public
    boolean supprimerNouvelle(Nouvelle n)
    {
        return this.listNouvelle.remove(n);
    }

    @Override
    public
    void bannirUnAbonne(Abonne a)
    {
        this.listAbonne.remove(a);
    }

    @Override
    public
    int ajouterAbonne(Abonne a)
    {
        this.listAbonne.add(a);
        a.forum = this;
        return this.listAbonne.indexOf(a);
    }

    @Override
    public
    void listerAbonnes()
    {
        String strListeAbonne = "";

        for (Abonne a : this.listAbonne)
        {
            strListeAbonne.concat(a.toString() + "\n");
        }

        informativeWindow(String.format("Les abonnés sont :%n%n%s", strListeAbonne), "liste_abonnés");
    }
}
