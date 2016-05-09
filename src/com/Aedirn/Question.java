package com.Aedirn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jeremy on 14/04/2016.
 */
public class Question {
    private int bonneReponse;
    private String question;
    private String[] reponses;
    private String nomFichier,reponse1,reponse2,reponse3,reponse4;




    public Question(String question, String reponse1,String reponse2, String reponse3, String reponse4, int bonneReponse)
    {
        this.bonneReponse=bonneReponse;
        this.question=question;
        reponses = new String[4];
        reponses[0]=(reponse1);
        reponses[1]=(reponse2);
        reponses[2]=(reponse3);
        reponses[3]=(reponse4);

    }
    public int getBonneReponse()
    {
        return bonneReponse;
    }
    public String getQuestion()
    {
        return question;
    }

    public String[] getReponses()
    {
        return reponses;
    }


}
