package test;

import static org.junit.Assert.assertTrue;

import decorator.BasicBee;
import decorator.Bee;
import decorator.BeeDecorator;
import decorator.HoneyBee;
import decorator.KillerBee;
import decorator.QueenBee;

import org.junit.Test;

public class DecoratorTest {

    @Test
    public void test() {
        Bee baseBee = new BasicBee(); 
        
        assertTrue(baseBee.getType().equalsIgnoreCase("Basic Drone Bee"));
        assertTrue(baseBee.getAttribute().equalsIgnoreCase("Pollen Gathering"));
        
        System.out.println(baseBee.getType());
        System.out.println(baseBee.getAttribute());
        
        Bee queen = new QueenBee(new BasicBee());
        
        assertTrue(queen.getType().equalsIgnoreCase("Basic Drone Bee, Queen Bee"));
        assertTrue(queen.getAttribute().equalsIgnoreCase("Pollen Gathering, Baby Making, Control"));
        
        Bee honeyQueen = new QueenBee(new HoneyBee(new BasicBee()));
        
        assertTrue(honeyQueen.getType().equalsIgnoreCase("Basic Drone Bee, Honey Bee, Queen Bee"));
        assertTrue(honeyQueen.getAttribute().equalsIgnoreCase("Pollen Gathering"
                + ", Honey Comb Building, Baby Making, Control"));
        
        Bee killerQueen = new QueenBee(new KillerBee(new BasicBee()));
        
        assertTrue(killerQueen.getType().equalsIgnoreCase("Basic Drone Bee, Killer Bee"
                + ", Queen Bee"));
        assertTrue(killerQueen.getAttribute().equalsIgnoreCase("Pollen Gathering, Killing Strength"
                + ", Baby Making, Control"));
        
        
        Bee honey = new HoneyBee(new BasicBee());
        
        System.out.println(honey.getType());
        System.out.println(honey.getAttribute());
        
        Bee killer = new KillerBee(new BasicBee());
        
        System.out.println(killer.getType());
        System.out.println(killer.getAttribute());
        
        System.out.println(killerQueen.toString());
    }

}
