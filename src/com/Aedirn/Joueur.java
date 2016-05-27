package com.Aedirn;

/**
 * Created by jeremy on 11/04/2016.
 */
public class Joueur {

    private String pseudo;
    private int score,ID;

    public Joueur(String pseudo, int ID)
    {
        this.ID = ID;
        this.pseudo=pseudo;
        score = 0;
    }

    public void affiche()
    {
        System.out.println("pseudo du joueur : "+pseudo+", score : "+score);
    }

    public String getPseudo()
    {
        return this.pseudo;
    }
    public int getScore()
    {
        return this.score;
    }

    public void setScore(int nouveauScore)
    {
        this.score= nouveauScore;
    }

    public int getID()
    {
        return ID;
    }

}
