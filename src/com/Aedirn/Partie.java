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

    public Partie(Joueur j1, Joueur j2)
    {
        this.j1 = j1;
        this.j2 = j2;
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
    public void repondre()
    {

    }

}
