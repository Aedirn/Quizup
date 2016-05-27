package com.Aedirn;

/**
 * Created by jeremy on 13/05/2016.
 */
import jdk.nashorn.internal.scripts.JO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.TreeMap;

public class QuizzUpServer extends UnicastRemoteObject implements QuizzUpInterface {

    private int lobby;
    private ArrayList lobbyJoueur = new ArrayList();
    String[][] qpa;
    String[][] qca;


    //TreeMap<String,Joueur> lobbyJoueur = new TreeMap<String,Joueur>();


    public QuizzUpServer() throws RemoteException
    {
        super();
        lobby=0;

    }


    public Boolean creerJoueur(String pseudo) // on créé un nouveau joueur avec cette méthode
    {
        Joueur joueur = new Joueur(pseudo);
        System.out.println("Joueur créé avec le pseudo : "+pseudo);

        lobbyJoueur.add(joueur);
        return true;
    }

    public int setID()
    {
        lobby++;
        return lobby;
    }

    public synchronized Boolean lobby() // pour placer un joueur en attente
    {
        while (lobby <2)
        {
            //System.out.println(lobby);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(lobby);

        }
        System.out.println("La partie va commencer");
        Joueur j1 = (Joueur) lobbyJoueur.get(0);
        Joueur j2 = (Joueur) lobbyJoueur.get(1);
        Partie partie = new Partie(j1,j2);
        return true;
    }

    public synchronized boolean resetLobby()
    {
        lobby=0;
        return true;
    }




    public synchronized boolean chargerQuestions()
    {
        qpa=new String[10][5];
        qca=new String[10][2];
        int i = 0;
        String nomTheme = "CULTURE";

        BufferedReader fichier = null;
        try {
            fichier = new BufferedReader(new FileReader("/Users/jeremy/Documents/Projets Java/Quizup/"+nomTheme+".txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String ligne = null;
        try {
            while ((ligne = fichier.readLine()) != null)
            {
                String[] mots = ligne.split(";");
                qpa[i][0] = mots[0];
                qpa[i][1] = mots[1];
                qpa[i][2] = mots[2];
                qpa[i][3] = mots[3];
                qpa[i][4] = mots[4];
                //numBonneRep = Integer.parseInt(mots[5]);

                qca[i][0]=mots[0];
                qca[i][1]=mots[5];
                i++;

            }
            fichier.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    public String[][] returnQpa()
    {
        return qpa;
    }

    public String[][] returnQca()
    {
        return qca;
    }


/*
    public boolean selecTheme() // on selectionne le theme
    {


    }
    public boolean resultat()
    {
        // prend en arg les score
        // dit qui a gagné
    }*/

    public static void main(String args[]) {

        try {
            QuizzUpServer quizz = new QuizzUpServer();
            System.out.println("server created");
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("quizz", quizz);
            System.out.println("quizz registered, waiting for connexions");
        } catch (Exception e) {
            System.err.println("quizz server exception: " + e.getMessage());
        }


    }


}

