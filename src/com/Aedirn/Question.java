package com.Aedirn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jeremy on 14/04/2016.
 */
public class Question {
    private int bonneReponse;
    private String question;
    private String[] reponses;


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
