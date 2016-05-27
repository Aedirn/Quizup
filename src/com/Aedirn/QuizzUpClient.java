package com.Aedirn;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Created by jeremy on 13/05/2016.
 */
public class QuizzUpClient {



    private QuizzUpClient()
    {
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int id;
        String host = "172.16.233.213";
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            QuizzUpInterface stub = (QuizzUpInterface) registry.lookup("quizz");
            System.out.println("Veuillez entrer votre pseudo : ");
            String pseudo = reader.next();
            stub.creerJoueur(pseudo);
            id = stub.setID();
            System.out.println("Vous êtes le joueur "+id);
            System.out.println("en attente de l'autre joueur ...");
            stub.lobby();
            System.out.println("Joueur trouvé ! La partie va commencer !!");
            stub.resetLobby();
            stub.chargerQuestions();
            String[][] qpa = stub.returnQpa();
            String[][] qca = stub.returnQca();
            new Quiz(qpa,qca);










        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }
}
