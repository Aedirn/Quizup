package com.Aedirn;

/**
 * Created by jeremy on 03/06/2016.
 */
public class RefreshMultiThread extends Thread {
    private QuizzUpClient quizzUpClient;
    private String pseudo;

    RefreshMultiThread(QuizzUpClient quizzUpClient, String pseudo)
    {
        this.pseudo = pseudo;
        this.quizzUpClient = quizzUpClient;
    }

    public void run()
    {
           quizzUpClient.initPartie(pseudo);
    }
}
