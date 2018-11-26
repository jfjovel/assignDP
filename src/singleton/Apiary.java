package singleton;

import builder.Hive;

import java.util.ArrayList;


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
    
    /**
     * Private call for the constructor so that only a single 
     * instance can be made and used.
     */
    private Apiary() {
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
    
    public ArrayList<Hive> getHives() {
        return hives;
    }
    
    /**
     * Method is used to add a new hive to the apiary.
     * @param newHive that is passed into it
     */
    public void addHive(Hive newHive) {
        hives.add(newHive);        
    }
    
    @Override 
    public String toString() {
        String message  = "This apiary is instance " 
                + System.identityHashCode(onlyInstance) 
                + " and has " + hives.size() + " hive(s)!";
        return message;
    }
}
