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

        Themes test = new Themes("test");

        System.out.println("Veuillez entrer le pseudo du joueur 1 : ");
        String pseudoj1 = reader.next();
        Joueur j1 = new Joueur(pseudoj1);


        System.out.println("Veuillez entrer le pseudo du joueur 2 : ");
        String pseudoj2 = reader.next();
        Joueur j2 = new Joueur(pseudoj2);

        j1.affiche();
        j2.affiche();

        Random rand = new Random();
        int value = rand.nextInt(2)+1;

        if (value==1)
        {
            System.out.println("Le joueur 1 choisit le thème :");

        }



        /*
        Joueur j1 =new Joueur("test1");
        Joueur j2 =new Joueur("test2");





        j1.setScore(32);
        j1.affiche();

        j2.affiche();

        Question q1 = new Question("choisis 1","1","2","3","4",1);
        System.out.println(q1.getQuestion());
        System.out.println(Arrays.toString(q1.getReponses()));
        System.out.println(q1.getBonneReponse());

        Question q2 = new Question("choisis 2","1","2","3","4",2);
        Question q3 = new Question("choisis 3","1","2","3","4",3);

        Themes test = new Themes("test");
        test.ajouterQuestion(q1);
        test.ajouterQuestion(q2);
        test.ajouterQuestion(q3);
        test.affiche();
        test.afficheClés();
        */


















    }

}
