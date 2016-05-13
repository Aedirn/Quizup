package com.Aedirn;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by jeremy on 13/05/2016.
 */
public interface QuizzUpInterface extends Remote {

    String sayHello() throws RemoteException;

    Boolean creerJoueur(String pseudo) throws RemoteException;

    Boolean lobby() throws RemoteException;

}
