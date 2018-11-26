package main;

import decorator.BasicBee;
import decorator.Bee;
import decorator.HoneyBee;
import decorator.KillerBee;
import decorator.QueenBee;
import facade.MainFrame;
import singleton.Apiary;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Main {

    /**
     * basic main class that will call forth and run the other patterns.
     * @param args just calls to create our pattern classes
     */
    public static void main(String[] args) {

        System.out.println("Creating new Apiary\n");
        Apiary onlyApiary = Apiary.getInstance();
        System.out.println("Here is the apiary:" + onlyApiary.toString() + ".\n");

        System.out.println("This is a call to create a second apiary.  Lets see "
                + "if it returns a new one!");
        Apiary secondApiary = Apiary.getInstance();
        System.out.println("Here is the second apiary:" + secondApiary.toString() + ".\n");

        System.out.println("It is the same instance.  So lets use the first call.");





        Bee baseBee = new BasicBee(); 

        System.out.println(baseBee.getType());
        System.out.println(baseBee.getAttribute());

        Bee queen = new QueenBee(new HoneyBee(new BasicBee()));

        System.out.println(queen.getType());
        System.out.println(queen.getAttribute());

        Bee honey = new HoneyBee(new BasicBee());

        System.out.println(honey.getType());
        System.out.println(honey.getAttribute());

        Bee killer = new KillerBee(new BasicBee());

        System.out.println(killer.getType());
        System.out.println(killer.getAttribute());

        System.out.println(killer.toString());
        ArrayList<Bee> bees = new ArrayList<Bee>();
        for(int i = 0; i < 5; i++) {
            bees.add(killer);
        }
        System.out.println(bees.toString());
        bees.remove(killer);
        System.out.println(bees.toString());


        MainFrame beesKnees = new MainFrame();
        beesKnees.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beesKnees.setSize(1024, 768);






    }

}
