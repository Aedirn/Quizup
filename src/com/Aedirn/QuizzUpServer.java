package com.Aedirn;

/**
 * Created by jeremy on 13/05/2016.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class QuizzUpServer extends UnicastRemoteObject implements QuizzUpInterface {

    private int lobby, IDJoueur, IDPartie, IDVainqueur, compteur;
    private ArrayList lobbyJoueur = new ArrayList();
    private ArrayList listePartie = new ArrayList();

    String[][] qpa;
    String[][] qca;


    HashMap<Integer,Joueur> joueurCo = new HashMap<>();
    HashMap<Integer,Partie> Parties = new HashMap<>();


    public QuizzUpServer() throws RemoteException
    {
        super();
        lobby=0;
        IDJoueur=0;
        IDPartie=0;
        compteur=0;
    }


    public Boolean creerJoueur(String pseudo) // on créé un nouveau joueur avec cette méthode
    {
        Joueur joueur = new Joueur(pseudo,IDJoueur);
        System.out.println("Joueur créé avec le pseudo : "+pseudo);
        joueurCo.put(lobby,joueur);
        lobbyJoueur.add(joueur);
        return true;
    }

    public int setID()
    {
        IDJoueur++;
        lobby++;
        return IDJoueur;
    }

    public synchronized int lobby() // pour placer un joueur en attente
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
        Parties.put(IDPartie,partie);
        return IDPartie;
    }



    public synchronized boolean resetLobby()
    {
        IDPartie++;
        lobby=0;
        return true;
    }

    public boolean registerScore(int IDJoueur, int score, int IDPartie )
    {
        Joueur joueur = joueurCo.get(IDJoueur);
        joueur.setScore(score);
        System.out.println("score : "+joueur.getScore());
        Partie partie = Parties.get(IDPartie);
        System.out.println("ID partie : "+ IDPartie);
        compteur++;

        return true;
    }

    public synchronized boolean winner(int IDPartie, int  IDJoueur)
    {
        Partie partie = Parties.get(IDPartie);
        while (compteur<2)
        {
            try {
                Thread.sleep(1000);
                System.out.println(compteur);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        IDVainqueur = partie.vainqueur();

        System.out.println("ID Vainqueur : "+IDVainqueur);
        if (IDJoueur==IDVainqueur)
            return true;
        else return false;
    }



    public synchronized boolean chargerQuestions(String nomTheme)
    {
        qpa=new String[10][5];
        qca=new String[10][2];
        int i = 0;
        //String nomTheme = "CULTURE";

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
    */

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

