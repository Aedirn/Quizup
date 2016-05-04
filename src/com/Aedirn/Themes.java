package com.Aedirn;

import java.util.Set;
import java.util.TreeMap;

/**
 * Created by jeremy on 14/04/2016.
 */
public class Themes {
    private Question questions;
    private String nomTheme;

    TreeMap<String, Question> theme = new TreeMap<String, Question>();

    public Themes(String nomTheme)
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


}
