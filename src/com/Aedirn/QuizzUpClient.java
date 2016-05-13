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

        String host = "localhost";
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            QuizzUpInterface stub = (QuizzUpInterface) registry.lookup("quizz");
            String response = stub.sayHello();
            System.out.println("response: " + response);

            System.out.println("Veuillez entrer votre pseudo : ");
            String pseudo = reader.next();
            stub.creerJoueur(pseudo);
            System.out.println("en attente de l'autre joueur ...");
            stub.lobby();






        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }
}
