package com.Aedirn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
		JLabel label = new JLabel("<html><br><br><center>Crédits :<br><br><br>Delphine COUTIN<br><br>Jérémy LAURENT<br><br>Gilles SAINTE-MARIE<br><br>Thibault VANDEVYVER<br><br></html>");
		//Font font = new Font("GOTHAM-BOLD", Font.BOLD, 20);
		try {
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("GOTHAM-BOLD.ttf")).deriveFont(Font.BOLD,20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GOTHAM-BOLD.ttf")));
			label.setFont(customFont);
		} catch (IOException e) {
			e.printStackTrace();
		} catch(FontFormatException e) {
			e.printStackTrace();
		}
		this.setLayout(new BorderLayout());
		retour.addActionListener (quizzUpClient);
		retour.setActionCommand("RETOUR");
		credits.add(label);
		this.add(credits, BorderLayout.NORTH);
		this.add(retour, BorderLayout.SOUTH);
	}
}
