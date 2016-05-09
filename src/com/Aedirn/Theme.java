package com.Aedirn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by jeremy on 04/05/2016.
 */
public class Theme {
    private Question questions;
    private String nomTheme;
    private String nomFichier,reponse1,reponse2,reponse3,reponse4,questionFichier;
    private int bonneReponse;


    TreeMap<String, Question> theme = new TreeMap<String, Question>();

    public Theme(String nomTheme)
    {
        this.nomTheme=nomTheme;
    }
    public void ajouterQuestion(Question question)
    {
        theme.put(question.getQuestion(),question);
    }
    public void affiche()
    {
        System.out.println(theme);
    }
    public String getNomTheme()
    {
        return nomTheme;
    }
    public void afficheClés()
    {
        Set<String> clés = theme.keySet();
        for (String clé : clés){
            System.out.println(clé);
        }
    }
    public void chargement(String nomTheme)
    {
        this.nomTheme = nomTheme;
        BufferedReader fichier = null;
        try {
            fichier = new BufferedReader(new FileReader(nomTheme));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String ligne = null;
        try {
            while ((ligne = fichier.readLine()) != null)
            {
                String[] mots = ligne.split(";");
                questionFichier = mots[0];
                reponse1 = mots[1];
                reponse2 = mots[2];
                reponse3 = mots[3];
                reponse4 = mots[4];
                bonneReponse = Integer.parseInt(mots[5]);
                Question question = new Question(questionFichier,reponse1,reponse2,reponse3, reponse4, bonneReponse);
                theme.put(questionFichier,question);


            }
            fichier.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}

