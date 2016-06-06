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

public class Fen4 extends Container{

	public Fen4(QuizzUpClient quizzUpClient)
	{
		JButton retour = new JButton("Retour");
		this.setLayout(new BorderLayout());
		retour.addActionListener (quizzUpClient);
		retour.setActionCommand("RETOUR");
		this.add(retour, BorderLayout.SOUTH);
	}
}
