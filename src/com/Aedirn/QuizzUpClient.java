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
        int idJoueur,idPartie;
        String host = "localhost";
        try {

            Registry registry = LocateRegistry.getRegistry(host);
            QuizzUpInterface stub = (QuizzUpInterface) registry.lookup("quizz");
            System.out.println("Veuillez entrer votre pseudo : ");
            String pseudo = reader.next();
            stub.creerJoueur(pseudo);
            idJoueur = stub.setID()-1;
            System.out.println("Vous êtes le joueur "+idJoueur);
            System.out.println("en attente de l'autre joueur ...");
            idPartie = stub.lobby();
            System.out.println("Joueur trouvé ! La partie va commencer !!");
            stub.resetLobby();
            stub.chargerQuestions();
            /*String[][] qpa = stub.returnQpa();
            String[][] qca = stub.returnQca();*/

            System.out.println("ID : " + idJoueur+" "+idPartie);
            Quiz quiz = new Quiz(stub,pseudo);

            int Score = quiz.calCorrectAnswer();
            System.out.println("Attente de l'autre joueur ...");
            stub.registerScore(idJoueur,Score,idPartie);

            if (stub.winner(idPartie,idJoueur))
                System.out.println("Vous avez gagné !");
            else System.out.println("vous avez perdu ;(");




        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }
}
