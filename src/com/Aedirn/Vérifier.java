package com.Aedirn;

/**
 * Created by jeremy on 14/04/2016.
 */
public class Vérifier {
    private int bonneReponse;

    public Vérifier(int bonneReponse)
    {
        this.bonneReponse = bonneReponse;
    }

    public void testReponse(int reponseJoueur, Joueur joueur)
    {
        if (reponseJoueur == bonneReponse)
        {
            joueur.setScore(joueur.getScore()+1);
        }
    }
}
