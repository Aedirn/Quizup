package com.Aedirn;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by jeremy on 13/05/2016.
 */
public interface QuizzUpInterface extends Remote {


    Boolean creerJoueur(String pseudo) throws RemoteException;

    int lobby() throws RemoteException;

    int setID() throws RemoteException;

    boolean chargerQuestions(String nomTheme) throws RemoteException;

    String[][] returnQca() throws RemoteException;

    String[][] returnQpa() throws RemoteException;

    boolean resetLobby() throws RemoteException;

    boolean registerScore(int IDJoueur, int score, int IDPartie) throws RemoteException;

    boolean winner(int IDPartie, int IDJoueur) throws RemoteException;

}
