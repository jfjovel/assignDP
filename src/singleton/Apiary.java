package singleton;

import java.util.ArrayList;

import builder.Hive;

/**
 * The class is a singleton type class that only instantiates
 * a single instance of itself and any calls to create more are 
 * returned with the same instance.
 * @author jfjovel
 *      Last Edited 11/23/18
 */
public class Apiary {
    private static Apiary onlyInstance = null;
    private ArrayList<Hive> hives;
    
    private Apiary(){
        hives = new ArrayList<Hive>();
    }
    
    /**
     * The method is called so that this class only returns a
     * single instance of the information provided in it.
     * The constructor is private and called only on the initial
     * instance call.
     * @return an instance of the Apiary information.
     */
    public static Apiary getInstance() {
        if (onlyInstance == null) {
            onlyInstance = new Apiary();
        }
        return onlyInstance;
    }
    
    public ArrayList<Hive> getHives(){
        return hives;
    }
    
    public void addHive(Hive newHive) {
        hives.add(newHive);        
    }
}
