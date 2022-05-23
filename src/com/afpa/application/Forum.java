package com.afpa.application;

import java.util.ArrayList;
import java.util.Date;

import static com.afpa.outil.Affichage.informativeWindow;
import static com.afpa.outil.Affichage.questionWindow;

class Forum implements iForumAbonne, iForumModerateur
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */ String nom;
    Date dateCreation;
    ArrayList<Nouvelle> listNouvelle = new ArrayList<>();
    ArrayList<Abonne> listAbonne = new ArrayList<>();

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    protected
    Forum(String nom)
    {
        setNom(nom);
        this.dateCreation = new Date();
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
    String getNom()
    {
        return nom;
    }

    protected
    void setNom(String nom)
    {
        if (!(nom.equals("")))
        {
            this.nom = nom.trim().toUpperCase();
        }
    }

    public
    int getIndex(Nouvelle nvl)
    {
        return listNouvelle.indexOf(nvl);
    }
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                    REDEFINITION DE TOSTRING()                */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @Override
    public
    String toString()
    {
        return String.format("Le forum '%s' a été créé le '%2$td %2$tB %2$tY'%n", nom, dateCreation);
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    protected
    void listerMessages()
    {
        StringBuilder strListeMessage = new StringBuilder();

        for (Nouvelle n : listNouvelle)
        {
            strListeMessage.append(n.toString()).append("\n");
        }

        informativeWindow(String.format("Liste messages :%n%n%s", strListeMessage), "liste_message");
    }

    // Implémentation droit abonnés

    @Override
    public
    boolean ajouterNouvelle(Nouvelle n)
    {
        return this.listNouvelle.add(n);
    }

    @Override
    public
    Nouvelle consulterNouvelle(int i)
    {
        return listNouvelle.get(i);
    }

    @Override
    public
    void repondreNouvelle(int i, Personne auteur)
    {

        this.listNouvelle.add(new Nouvelle(this.listNouvelle.get(i).sujet, questionWindow(
                String.format("Entrer votre réponse au sujet '%s'.", this.listNouvelle.get(i).sujet), "votre_réponse"),
                                           auteur));
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    // Implémentation droit modérateur

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
        a.setForum(null);
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
        StringBuilder strListeAbonne = new StringBuilder();

        for (Abonne a : listAbonne)
        {
            strListeAbonne.append(a.toStringMetadata()).append("\n");
        }

        informativeWindow(String.format("Les abonnés sont :%n%n%s", strListeAbonne.toString()), "liste_abonnés");
    }
}
