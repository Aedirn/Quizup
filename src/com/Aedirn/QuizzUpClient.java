package com.Aedirn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Created by jeremy on 13/05/2016.
 */
public class QuizzUpClient extends JFrame implements ActionListener
{
    private Container cp;
    private Contenu c2;
    private Confirmation confirmation;
    private Fen4 cp3;
    private FenetreAttente fenetreAttente;
    private int idJoueur, idPartie;

    private QuizzUpClient(QuizzUpInterface stub)
    {
        JButton jeu = new JButton("Jouer");
        JButton cred = new JButton("Credits");
        JButton quit = new JButton("Quitter");

        this.setLayout(new GridLayout(2,1));
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        GridLayout grid = new GridLayout(3,1);

        grid.setVgap(2);
        JPanel panel = new JPanel(grid);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("QuizUP");


        ImageIcon image = new ImageIcon("quizup-logo.png");
        JLabel label = new JLabel("", image, JLabel.CENTER);


        cp = getContentPane();

        confirmation = new Confirmation(this);
        c2 = new Contenu(this, stub);




        jeu.addActionListener(this);
        jeu.setActionCommand("JEU");
        //this.add(jeu);

        cred.addActionListener(this);
        cred.setActionCommand("M2");
        //this.add(cred);

        cp3 = new Fen4(this);


        quit.addActionListener(this);
        quit.setActionCommand("QUIT");
        //this.add(quit);

        this.add(label);
        this.add(panel);
        panel.add(jeu);
        panel.add(cred);
        panel.add(quit);

        this.setVisible(true);
    }

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int idJoueur,idPartie;
        String host = "localhost";

        try {
            Registry registry = LocateRegistry.getRegistry();
            QuizzUpInterface stub = (QuizzUpInterface) registry.lookup("quizz");
            QuizzUpClient quizzUpClient = new QuizzUpClient(stub);



            /*System.out.println("Veuillez entrer votre pseudo : ");
            String pseudo = reader.next();
            stub.creerJoueur(pseudo);
            idJoueur = stub.setID()-1;
            System.out.println("Vous êtes le joueur "+idJoueur);
            System.out.println("en attente de l'autre joueur ...");
            idPartie = stub.lobby();
            System.out.println("Joueur trouvé ! La partie va commencer !!");
            stub.resetLobby();
            stub.chargerQuestions("MONDE");
            /*String[][] qpa = stub.returnQpa();
            String[][] qca = stub.returnQca();

            System.out.println("ID : " + idJoueur+" "+idPartie);
            Quiz quiz = new Quiz(stub,pseudo);

            int Score = quiz.calCorrectAnswer();
            System.out.println("Attente de l'autre joueur ...");
            stub.registerScore(idJoueur,Score,idPartie);

            if (stub.winner(idPartie,idJoueur))
                System.out.println("Vous avez gagné !");
            else System.out.println("vous avez perdu ;(");




*/

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }

    public void initPartie(String pseudo) {
        int idJoueur, idPartie;
        String host = "localhost";

        try {
            Registry registry = LocateRegistry.getRegistry();
            QuizzUpInterface stub = (QuizzUpInterface) registry.lookup("quizz");
            stub.creerJoueur(pseudo);
            setup(stub,pseudo);


        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
    public void setup(QuizzUpInterface stub, String pseudo)
    {
        try {
            idJoueur = stub.setID()-1;
            System.out.println("Vous êtes le joueur "+idJoueur);
            System.out.println("en attente de l'autre joueur ...");
            idPartie = stub.lobby();
            System.out.println("Joueur trouvé ! La partie va commencer !!");
            stub.resetLobby();
            stub.chargerQuestions("CULTURE");
            /*String[][] qpa = stub.returnQpa();
            String[][] qca = stub.returnQca();*/

            System.out.println("ID : " + idJoueur+" "+idPartie);
            this.setVisible(false);
            Quiz quiz = new Quiz(stub,pseudo);
            this.setVisible(true);

            int Score = quiz.calCorrectAnswer();
            System.out.println("Attente de l'autre joueur ...");
            stub.registerScore(idJoueur,Score,idPartie);

            if (stub.winner(idPartie,idJoueur))
                System.out.println("Vous avez gagné !");
            else System.out.println("vous avez perdu ;(");

        } catch (RemoteException e) {
            e.printStackTrace();
        }





    }
    public void repaint(String pseudo)
    {
        fenetreAttente = new FenetreAttente(this,pseudo);

        this.setContentPane(fenetreAttente);
        this.validate();
        this.repaint();
        initPartie(pseudo);
    }

        @Override
         public void actionPerformed(ActionEvent e) {

        String clic = e.getActionCommand();
        switch(clic)
        {
            case "JEU":
                this.setContentPane(c2);
                this.validate();
                break;
            case "RETOUR":
                this.setContentPane(cp);
                this.validate();
                break;
            case "QUIT":
                confirmation.setVisible(true);
                break;
            case "M2":
                this.setContentPane(cp3);
                this.validate();
                break;
            case "Enter":
                String pseudo = c2.getText();
                System.out.println(pseudo);
                repaint(pseudo);
                this.setVisible(true);
                break;






        }

    }
}
