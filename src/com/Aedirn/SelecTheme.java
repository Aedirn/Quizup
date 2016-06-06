package com.Aedirn;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jeremy on 04/06/2016.
 */
public class SelecTheme extends Container {

    public SelecTheme(QuizzUpClient quizzUpClient)
    {

        JButton culture = new JButton("Culture");
        culture.setActionCommand("CULTURE");
        culture.addActionListener(quizzUpClient);

        JButton monde = new JButton("Monde");
        monde.setActionCommand("MONDE");
        monde.addActionListener(quizzUpClient);

        JButton science = new JButton("Science");
        science.setActionCommand("SCIENCE");
        science.addActionListener(quizzUpClient);

        JButton civilisation = new JButton("Civilisation");
        civilisation.setActionCommand("CIVILISATION");
        civilisation.addActionListener(quizzUpClient);

        JPanel bas = new JPanel(new GridLayout(2,2));
        bas.add(civilisation);
        bas.add(culture);
        bas.add(monde);
        bas.add(science);

        JLabel text = new JLabel("Veuillez choisir un thème : ");

        this.setLayout(new GridLayout(2,1));

        this.add(text,BoxLayout.PAGE_AXIS);
        this.add(bas);



    }
}
