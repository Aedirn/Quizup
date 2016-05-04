package com.Aedirn;

/*import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;*/
import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        Question q1 = new Question("choisis 1","1","2","3","4",1);
        System.out.println(q1.getQuestion());
        System.out.println(Arrays.toString(q1.getReponses()));
        System.out.println(q1.getBonneReponse());

        Question q2 = new Question("choisis 2","1","2","3","4",2);
        Question q3 = new Question("choisis 3","1","2","3","4",3);

        Theme test1 = new Theme("test1");

        test1.ajouterQuestion(q1);
        test1.ajouterQuestion(q2);
        test1.ajouterQuestion(q3);


        Theme test2 = new Theme("test2");
        test2.ajouterQuestion(q1);
        test2.ajouterQuestion(q2);
        test2.ajouterQuestion(q3);

        Themes collection = new Themes();

        collection.ajouterTheme(test1);
        collection.ajouterTheme(test2);



        System.out.println("Veuillez entrer le pseudo du joueur 1 : ");
        String pseudoj1 = reader.next();
        Joueur j1 = new Joueur(pseudoj1);


        System.out.println("Veuillez entrer le pseudo du joueur 2 : ");
        String pseudoj2 = reader.next();
        Joueur j2 = new Joueur(pseudoj2);

        j1.affiche();
        j2.affiche();
        Partie partie = new Partie(j1,j2);
        partie.selecTheme();
        collection.afficheThemes();

        String clé = reader.next();
        Theme themeChoisi = collection.choisirTheme(clé);

        System.out.println("les question du thèmes choisi sont :");
        themeChoisi.afficheClés();








        /*
        Joueur j1 =new Joueur("test11");
        Joueur j2 =new Joueur("test12");





        j1.setScore(32);
        j1.affiche();

        j2.affiche();

        Question q1 = new Question("choisis 1","1","2","3","4",1);
        System.out.println(q1.getQuestion());
        System.out.println(Arrays.toString(q1.getReponses()));
        System.out.println(q1.getBonneReponse());

        Question q2 = new Question("choisis 2","1","2","3","4",2);
        Question q3 = new Question("choisis 3","1","2","3","4",3);

        Themes test1 = new Themes("test1");
        test1.ajouterQuestion(q1);
        test1.ajouterQuestion(q2);
        test1.ajouterQuestion(q3);
        test1.affiche();
        test1.afficheClés();
        */


















    }

}
