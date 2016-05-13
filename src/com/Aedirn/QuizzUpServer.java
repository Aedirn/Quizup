package com.Aedirn;

/**
 * Created by jeremy on 13/05/2016.
 */
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class QuizzUpServer extends UnicastRemoteObject implements QuizzUpInterface {

    public QuizzUpServer() throws RemoteException {
        super();
    }

    public String sayHello() {
        return "Hello, world!";
    }
    public static void main(String args[]) {

        try {
            QuizzUpServer quizz = new QuizzUpServer();
            System.out.println("server created");
            //  			Adder stub = (Adder) UnicastRemoteObject.exportObject(adder, 0); // pas nécessaire puisque AdderImpl dérive de UnicastRemoteObject
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("quizz", quizz);
            System.out.println("quizz registered, waiting for connexions");
        } catch (Exception e) {
            System.err.println("quizz server exception: " + e.getMessage());
        }


    }


}

