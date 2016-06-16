package com.Aedirn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.*;
import javax.swing.border.Border;

public class FenetreLogin extends Container implements ActionListener {
	public JTextField saisie;
	private JLabel label1, label2, label3;
	private JButton bout1;
	QuizzUpInterface stub;
	QuizzUpClient quizzUpClient;

	public FenetreLogin(QuizzUpClient quizzUpClient, QuizzUpInterface stub) {
		this.stub = stub;
		this.quizzUpClient = quizzUpClient;
		JButton retour = new JButton("Retour");
		this.setLayout(new GridLayout(2,1));
		retour.addActionListener((ActionListener) quizzUpClient);
		retour.setActionCommand("RETOUR");


		JPanel textfield = new JPanel(new GridLayout(2, 1,10,10));
		JPanel down = new JPanel(new GridLayout(3,2));



		Border vide = BorderFactory.createRaisedBevelBorder();


		label1 = new JLabel("Entrez votre pseudo :");
		label1.setOpaque(true);
		//label1.setPreferredSize(new Dimension(200, 20));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setBackground(Color.white);
		label1.setForeground(Color.black);
		label1.setBorder(vide);

		label1.setLayout(new FlowLayout());
		JLabel filler1  = new JLabel("");
		JLabel filler2  = new JLabel("");
		JLabel filler3  = new JLabel("");
		JLabel filler4  = new JLabel("");

		saisie = new JTextField(20);
		saisie.setPreferredSize(new Dimension(100,20));
		//saisie.addActionListener(this);


		bout1 = new JButton("Valider");
		bout1.setActionCommand("Enter");
		bout1.addActionListener(quizzUpClient);

		textfield.add(label1);
		textfield.add(saisie);

		this.add(textfield);


		down.add(filler1);
		down.add(filler2);

		down.add(bout1);
		down.add(retour,BorderLayout.SOUTH);

		down.add(filler3);
		down.add(filler4);

		this.add(down);


	}

	public String getText() {
		return saisie.getText();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
