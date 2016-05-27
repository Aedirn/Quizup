package com.Aedirn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by jeremy on 20/05/2016.
 */
public class Quiz extends JFrame implements ActionListener {
    JPanel panel;
    JPanel panelresult;
    JRadioButton Choix1;
    JRadioButton Choix2;
    JRadioButton Choix3;
    JRadioButton Choix4;
    ButtonGroup bg;
    JLabel lblmess;
    JButton btnext;
    String[][] qpa;
    String[][] qca;
    int qaid;
    HashMap<Integer, String> map;

    public Quiz(String[][] qpa, String[][] qca){
        this.qca=qca;
        this.qpa=qpa;
        initializedata();
        setTitle("Quizz'UP !");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(430,350);
        setLocation(300,100);
        setResizable(false);
        Container cont=getContentPane();
        cont.setLayout(null);
        cont.setBackground(Color.GRAY);
        bg=new ButtonGroup();
        Choix1=new JRadioButton("Choix1",true);
        Choix2=new JRadioButton("Choix2",false);
        Choix3=new JRadioButton("Choix3",false);
        Choix4=new JRadioButton("Choix4",false);
        bg.add(Choix1);
        bg.add(Choix2);
        bg.add(Choix3);
        bg.add(Choix4);
        lblmess=new JLabel("Choisissez la bonne réponse :");
        lblmess.setForeground(Color.BLUE);
        lblmess.setFont(new Font("Arial", Font.BOLD, 11));
        btnext=new JButton("Suivant");
        btnext.setForeground(Color.GREEN);
        btnext.addActionListener(this);
        panel=new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLocation(10,10);
        panel.setSize(400,300);
        panel.setLayout(new GridLayout(6,2));
        panel.add(lblmess);
        panel.add(Choix1);
        panel.add(Choix2);
        panel.add(Choix3);
        panel.add(Choix4);
        panel.add(btnext);
        cont.add(panel);
        setVisible(true);
        qaid=0;
        readqa(qaid);

    }

    public void actionPerformed(ActionEvent e){

        if(btnext.getText().equals("Suivant")){
            if(qaid<9){

                map.put(qaid,getSelection());
                qaid++;
                readqa(qaid);
            }
            else {
                map.put(qaid,getSelection());
                btnext.setText("Résultat");

            }
        }
        else if(btnext.getText().equals("Résultat"))
            new Report();


    }



    public void initializedata(){

        //qpa stores pairs of question and its possible answers
        qpa=new String[10][5];
        qca=new String[10][2];


        int i = 0;
        int numBonneRep;

        String nomTheme = "CULTURE";

        BufferedReader fichier = null;
        try {
            fichier = new BufferedReader(new FileReader(nomTheme+".txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String ligne = null;
        try {
            while ((ligne = fichier.readLine()) != null)
            {
                String[] mots = ligne.split(";");
                qpa[i][0] = mots[0];
                qpa[i][1] = mots[1];
                qpa[i][2] = mots[2];
                qpa[i][3] = mots[3];
                qpa[i][4] = mots[4];
                //numBonneRep = Integer.parseInt(mots[5]);

                qca[i][0]=mots[0];
                qca[i][1]=mots[5];
                i++;

            }
            fichier.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        //create a map object to store pairs of question and selected answer
        map=new HashMap<Integer, String>();

    }
    public String getSelection(){
        String selectedChoice=null;
        Enumeration<AbstractButton> buttons=bg.getElements();
        while(buttons.hasMoreElements())
        {
            JRadioButton temp=(JRadioButton)buttons.nextElement();
            if(temp.isSelected())
            {
                selectedChoice=temp.getText();
            }
        }
        return(selectedChoice);
    }


    public void readqa(int qid){
        lblmess.setText("  "+qpa[qid][0]);
        Choix1.setText(qpa[qid][1]);
        Choix2.setText(qpa[qid][2]);
        Choix3.setText(qpa[qid][3]);
        Choix4.setText(qpa[qid][4]);
        Choix1.setSelected(true);
    }
    public void reset(){

        qaid=0;
        map.clear();
        readqa(qaid);
        btnext.setText("Suivant");
    }
    public int calCorrectAnswer(){
        int qnum=10;
        int count=0;
        for(int qid=0;qid<qnum;qid++)
            if(qca[qid][1].equals(map.get(qid))) count++;
        return count;
    }

    public class Report extends JFrame {
        Report(){
            setTitle("Réponses");
            setSize(850,550);
            setBackground(Color.WHITE);
            addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    dispose();
                    reset();
                }
            });
            Draw d=new Draw();
            add(d);
            setVisible(true);
        }


        class Draw extends Canvas{
            public void paint(Graphics g){
                int qnum=10;
                int x=10;
                int y=20;
                for(int i=0;i<qnum;i++){
                    //print the 1st column
                    g.setFont(new Font("Arial",Font.BOLD,12));
                    g.drawString(i+1+". "+qca[i][0], x,y);
                    y+=30;
                    g.setFont(new Font("Arial",Font.PLAIN,12));
                    g.drawString("      Bonne réponse : "+qca[i][1], x,y);
                    y+=30;
                    g.drawString("      Votre réponse : "+map.get(i), x,y);
                    y+=30;
                    //print the 2nd column
                    if(y>400)
                    {y=20;
                        x=450;
                    }

                }
                //Show number of correct answers
                int numc=calCorrectAnswer();
                g.setColor(Color.BLUE);
                g.setFont(new Font("Arial",Font.BOLD,14));
                g.drawString("Votre score  : "+numc+" points",300,500);


            }
        }

    }




}