package test;

import static org.junit.Assert.assertTrue;

import builder.Hive;
import builder.HiveBuilder;
import builder.HiveDirector;
import builder.KillerBuilder;
import org.junit.Test;
import singleton.Apiary;

public class SingletonTest {

    /**
     * The overall test is for the singleton class.  It will
     * check to make sure that only a single instance of the class is active
     * even when calling for additional constructors.
     */
    @Test
    public void test() {
        Apiary firstOne = Apiary.getInstance();
        int hashCode = System.identityHashCode(firstOne);
        
        Apiary secondOne = Apiary.getInstance();
        int hashCode2 = System.identityHashCode(secondOne);
        
        assertTrue(hashCode == hashCode2);
        
        //Initiate Hive Director to build the hives
        HiveDirector hd = new HiveDirector();
        
        //First hive Builder tested will be for killer Bees
        HiveBuilder killerBuilder = new KillerBuilder();
        hd.setBuilder(killerBuilder);
        hd.makeHive();
        Hive killerHive = hd.getHive();
        
        firstOne.addHive(killerHive);
        
        assertTrue(firstOne.getHives().size() == 1);
        
        
        
    }

}
