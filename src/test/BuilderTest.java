package test;

import static org.junit.Assert.assertTrue;

import builder.BasicBuilder;
import builder.Hive;
import builder.HiveBuilder;
import builder.HiveDirector;
import builder.HoneyBuilder;
import builder.KillerBuilder;
import decorator.Bee;

import org.junit.Test;



public class BuilderTest {

    @Test
    public void test() {
        //Initiate Hive Director to build the hives
        HiveDirector hd = new HiveDirector();
        
        //First hive Builder tested will be for killer Bees
        HiveBuilder killerBuilder = new KillerBuilder();
        hd.setBuilder(killerBuilder);
        hd.makeHive();
        Hive killerHive = hd.getHive();
        
        //after initiating the hive we test to make sure
        //the correct bee type was created.
        String killer = "Basic Drone Bee, Killer Bee";
        assertTrue(killerHive.getBeeType().equals(killer));
        assertTrue(killerHive.rooms == 15);
        
        //verify the queen that is added to the hive is a killer queen
        Bee tempQueen = killerHive.getQueen();
        String queenAttr = "Pollen Gathering, Killing Strength, Baby Making, Control";
        assertTrue(tempQueen.getAttribute().equals(queenAttr));
        
        //Initiate builder for honey bee hive
        HiveBuilder honeyBuilder = new HoneyBuilder();
        hd.setBuilder(honeyBuilder);
        hd.makeHive();
        Hive honeyHive = hd.getHive();
        String honey = "Pollen Gathering, Honey Comb Building";
        assertTrue(honeyHive.getBeeAttribute().equals(honey));
        assertTrue(honeyHive.rooms == 35);
        
        //Build basic bee hive.
        HiveBuilder basicBuilder = new BasicBuilder();
        hd.setBuilder(basicBuilder);
        hd.makeHive();
        Hive basicHive = hd.getHive();
        assertTrue(basicHive.workers.size() == 1000);
        assertTrue(basicHive.rooms == 100);
        
        //add Room and check if worker amount and room amount changed.
        basicHive.addRoom();
        assertTrue(basicHive.getWorkers().size() == 1010);
        assertTrue(basicHive.getRooms() == 101);
        
        //kill 3 bees and verify that the bee count has changed.
        basicHive.killBee();
        basicHive.killBee();
        basicHive.killBee();
        assertTrue(basicHive.workers.size() == 1007);
        
        
    }

}
