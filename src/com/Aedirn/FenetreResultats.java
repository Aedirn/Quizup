package com.Aedirn;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jeremy on 03/06/2016.
 */
public class FenetreResultats extends Container {

    public FenetreResultats(QuizzUpClient quizzUpClient,String text)
    {
        JLabel resultat = new JLabel(text);
        JButton retour = new JButton("Retour");
        this.setLayout(new GridLayout(2,1));
        JPanel up = new JPanel();
        JPanel down = new JPanel(new BorderLayout());
        retour.addActionListener (quizzUpClient);
        retour.setActionCommand("RETOUR");
        up.add(resultat);
        down.add(retour, BorderLayout.SOUTH);

        this.add(up);
        this.add(down);
    }

}
