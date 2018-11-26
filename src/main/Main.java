package main;

import decorator.BasicBee;
import decorator.Bee;
import decorator.HoneyBee;
import decorator.KillerBee;
import decorator.QueenBee;
import facade.MainFrame;

import java.util.ArrayList;

import javax.swing.JFrame;

import builder.Hive;
import builder.HiveBuilder;
import builder.HiveDirector;
import builder.HoneyBuilder;
import builder.KillerBuilder;
import singleton.Apiary;





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


        System.out.println("Now we will create different Bee Types.");

        Bee baseBee = new BasicBee(); 

        System.out.println("Basic Bee Type: " + baseBee.getType());
        System.out.println("Basic Bee Attribute: " + baseBee.getAttribute());
        System.out.println();

        Bee honey = new HoneyBee(new BasicBee());

        System.out.println("Honey Bee Type: " + honey.getType());
        System.out.println("Honey Bee Attribute: " + honey.getAttribute());
        System.out.println();
        
        Bee killer = new KillerBee(new BasicBee());

        System.out.println("Killer Bee Type: " + killer.getType());
        System.out.println("Killer Bee Attribute: " + killer.getAttribute());
        System.out.println();
        
        Bee queen = new QueenBee(new HoneyBee(new BasicBee()));

        System.out.println("Queen Honey Bee Type: " + queen.getType());
        System.out.println("Queen Honey Bee Attribute: " + queen.getAttribute());
        System.out.println();
        
        
        System.out.println("each different type of bee is decorated on.");
        System.out.println("\n Now lets create some hives.  The way it works"
                + " is that we initially call a director.  Then we call on builders."
                + "  When the builder is made we set the director's builder to that builder"
                + " and then call to make the hive and return the new hive created.");

        HiveDirector hiDirec = new HiveDirector();
        
        HiveBuilder killerBuild = new KillerBuilder();
        
        hiDirec.setBuilder(killerBuild);
        hiDirec.makeHive();
        Hive killerHive = hiDirec.getHive();
        System.out.println("Now we have a new Killer Bee Hive!\n");
        System.out.println(killerHive.toString());
        System.out.println("\nLets go through the same process for a Honey bee hive.");
        
        HiveBuilder honeyBuild = new HoneyBuilder();
        hiDirec.setBuilder(honeyBuild);
        hiDirec.makeHive();
        Hive honeyHive = hiDirec.getHive();
        System.out.println("\nVoila, now we have a Honey Bee Hive.");
        System.out.println(honeyHive.toString());
        
        System.out.println("\nEach hive has a queen and their own attributes");
        System.out.println("Killer Bee Queen: " + killerHive.getQueen().getAttribute());
        System.out.println("Honey Bee Queen: " + honeyHive.getQueen().getAttribute());
        
        System.out.println("\nNow that we have hives lets go back to the apiary"
                + " and see how many hives it has in it.");
        System.out.println(onlyApiary.toString());
        System.out.println("\nLets go ahead and add our 2 hives to the apiary.");
        onlyApiary.addHive(killerHive);
        onlyApiary.addHive(honeyHive);
        System.out.println("\nLets print out the hives stored in the apiary:" 
                + onlyApiary.getHives().toString());
        System.out.println(onlyApiary.toString());
        
        System.out.println("\nLets see what the second apiary shows now: ");
        System.out.println(secondApiary.toString());
        System.out.println("\nMore proof that it is a singleton.");
        
        System.out.println("\n\nNow the gui will launch with these 2 hives in the apiary "
                + "and the ability to add more to it!  Enjoy!");
        

        MainFrame beesKnees = new MainFrame();
        beesKnees.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beesKnees.setSize(1024, 768);






    }

}
