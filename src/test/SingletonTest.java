package test;

import static org.junit.Assert.assertTrue;

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
        
        
        
    }

}
