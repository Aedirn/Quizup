package com.Aedirn;

import java.util.Set;
import java.util.TreeMap;

/**
 * Created by jeremy on 14/04/2016.
 */
public class Themes {
    private Question questions;

    TreeMap<String, Theme> themes = new TreeMap<String, Theme>();

    public Themes()
    {

    }
    public void ajouterTheme(Theme theme)
    {
        themes.put(theme.getNomTheme(),theme);
    }

    public void afficheThemes()
    {

        Set<String> clés = themes.keySet();
        for (String clé : clés){
            System.out.println(clé);
        }

    }




}
