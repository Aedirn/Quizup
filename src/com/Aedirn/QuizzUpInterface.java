package com.Aedirn;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by jeremy on 13/05/2016.
 */
public interface QuizzUpInterface extends Remote {


    Boolean creerJoueur(String pseudo) throws RemoteException;

    Boolean lobby() throws RemoteException;

    int setID() throws RemoteException;

    boolean chargerQuestions() throws RemoteException;

    String[][] returnQca() throws RemoteException;

    String[][] returnQpa() throws RemoteException;

    boolean resetLobby() throws RemoteException;

}
