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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Contenu extends Container implements ActionListener {
	public JTextField saisie;
	private JLabel label1, label2, label3;
	private JButton bout1;
	QuizzUpInterface stub;
	QuizzUpClient quizzUpClient;

	public Contenu(QuizzUpClient quizzUpClient, QuizzUpInterface stub) {
		this.stub = stub;
		this.quizzUpClient = quizzUpClient;
		JButton retour = new JButton("Retour");
		this.setLayout(new GridLayout(2,1));
		retour.addActionListener((ActionListener) quizzUpClient);
		retour.setActionCommand("RETOUR");

		JPanel textfield = new JPanel(new GridLayout(2, 1));
		JPanel down = new JPanel(new GridLayout(2,4));

		label1 = new JLabel("Entrez votre pseudo :");
		label1.setOpaque(true);
		label1.setPreferredSize(new Dimension(200, 20));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setBackground(Color.white);
		label1.setForeground(Color.black);

		JLabel filler1  = new JLabel("");
		JLabel filler2  = new JLabel("");
		JLabel filler3  = new JLabel("");
		JLabel filler4  = new JLabel("");

		saisie = new JTextField(20);
		saisie.setPreferredSize(new Dimension(100,20));
		//saisie.addActionListener(this);

		/*label2 = new JLabel();
		label2.setOpaque(true);
		label2.setPreferredSize(new Dimension(200, 20));
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setBackground(Color.white);
		label2.setForeground(Color.black);
		textfield.add(label2);*/

		bout1 = new JButton("Valider");
		bout1.setActionCommand("Enter");
		bout1.addActionListener(quizzUpClient);

		textfield.add(label1);
		textfield.add(saisie);



		down.add(filler1);
		down.add(filler2);

		down.add(bout1);

		//down.add(filler3);

		down.add(retour);
		//down.add(filler4);

		this.add(textfield);
		this.add(down);


	}

	public String getText() {
		return saisie.getText();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
