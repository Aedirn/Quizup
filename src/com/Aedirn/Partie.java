package com.Aedirn;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by jeremy on 11/04/2016.
 */
public class Partie {

    private Joueur j1,j2;
    private Themes themes;
    private int compteur;

    public Partie(Joueur j1, Joueur j2)
    {
        this.j1 = j1;
        this.j2 = j2;
        compteur=0;
    }

    public int selecTheme()
    {
        Random rand = new Random();
        int value = rand.nextInt(2)+1;
        if (value==1)
        {
            System.out.println("Le joueur 1 choisit le thème :");
            return 1;
        }

        else
        {
            System.out.println("Le joueur 2 choisit le thème :");
            return 2;
        }


    }
    public int getScoreJ1()
    {
        return j1.getScore();
    }

    public int getjScoreJ2()
    {
        return j2.getScore();
    }

    public synchronized Boolean completion()
    {
        compteur++;
        while (compteur<2)
        {
            try {
                Thread.sleep(1000);
                System.out.println(compteur);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public int vainqueur()
    {
        if (j1.getScore()>j2.getScore())
            return j1.getID();
        else return j2.getID();
    }


}
