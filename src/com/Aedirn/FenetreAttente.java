package com.Aedirn;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jeremy on 30/05/2016.
 */
public class FenetreAttente extends Container {



    public FenetreAttente(QuizzUpClient quizzUpClient)
    {
        JLabel text = new JLabel("En attente de l'autre joueur ...");
        JButton retour = new JButton("Retour");
        this.setLayout(new GridLayout(2,2));
        retour.addActionListener (quizzUpClient);
        retour.setActionCommand("RETOUR");
        this.add(text);
        this.add(retour);
    }



}
