package com.Aedirn;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by jeremy on 13/05/2016.
 */
public class QuizzUpClient {

    private QuizzUpClient()
    {

    }

    public static void main(String[] args) {

        String host = "localhost";
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            QuizzUpInterface stub = (QuizzUpInterface) registry.lookup("quizz");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
