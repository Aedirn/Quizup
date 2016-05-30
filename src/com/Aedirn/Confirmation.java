package com.Aedirn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Confirmation extends JDialog implements ActionListener 
{
	
	private JButton oui, non;
	
	public Confirmation(JFrame fenetre)
	{
		super(fenetre, "Confirmation", true);
		this.setVisible(false);
		this.setSize(300,100);
		this.setLocation(250,250);
		this.setLayout(new GridLayout(2,1));
		this.setLocationRelativeTo(fenetre);

		JLabel text = new JLabel("Voulez-vous vraiment quitter ?");

		JPanel up = new JPanel();
		JPanel down = new JPanel();

		up.add(text);
		
		oui = new JButton("Oui");
		oui.addActionListener(this);
		oui.setActionCommand("OUI");
		down.add(oui);
		
		non = new JButton("Non");
		non.addActionListener(this);
		non.setActionCommand("NON");
		down.add(non);

		this.add(up);
		this.add(down);
	}



	
	@Override
	public void actionPerformed(ActionEvent e) {
		String evenement = e.getActionCommand();
		
		switch(evenement)
		{
		case "OUI":
		{
			System.exit(0);
			break;
		}
		case "NON":
		{
			this.setVisible(false);
			break;
		}
		default:
		{
			System.err.println("cas non prévu");
		}
	}

	}
}
