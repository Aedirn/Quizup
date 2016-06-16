package com.Aedirn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreCredits extends Container{

	public FenetreCredits(QuizzUpClient quizzUpClient)
	{
		JButton retour = new JButton("Retour");
		JPanel credits = new JPanel();
		JLabel text = new JLabel("Credits : TEs "+"\n test ");
		this.setLayout(new BorderLayout());
		retour.addActionListener (quizzUpClient);
		retour.setActionCommand("RETOUR");
		credits.add(text);
		this.add(credits, BorderLayout.NORTH);
		this.add(retour, BorderLayout.SOUTH);
	}
}
