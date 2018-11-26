package builder;

import decorator.BasicBee;
import decorator.Bee;
import decorator.HoneyBee;
import decorator.KillerBee;

import java.util.ArrayList;



public class Hive {
    private static final String KILLTYPE = "Basic Drone Bee, Killer Bee";
    private static final String HONEYTYPE = "Basic Drone Bee, Honey Bee";
    
    public String beeType;
    public String beeAttribute;
    public Bee queen;
    public ArrayList<Bee> workers = new ArrayList<Bee>();
    public int rooms;
    


    public String getBeeType() {
        return beeType;
    }

    public String getBeeAttribute() {
        return beeAttribute;
    }

    public Bee getQueen() {
        return queen;
    }

    public ArrayList<Bee> getWorkers() {
        return workers;
    }

    public int getRooms() {
        return rooms;
    }
    
    /**
     * Method is used to add a room to a beehive.  When a room 
     * is added the method asks what kind of type the beehive is
     * and then adds 10 of that type of bee per room.
     */
    public void addRoom() {
        rooms += 1;
        if (beeType.equalsIgnoreCase(KILLTYPE)) {
            for (int i = 0; i < 10; i++) {
                workers.add(new KillerBee(new BasicBee()));
            }
            
        } else if (beeType.equalsIgnoreCase(HONEYTYPE)) {
            for (int i = 0; i < 10; i++) {
                workers.add(new HoneyBee(new BasicBee()));
            }
        } else {
            for (int i = 0; i < 10; i++) {
                workers.add(new BasicBee());
            }
        }

    }
    
    /**
     * Method is used to remove a bee from the hive when it is killed.
     */
    public void killBee() {
        workers.remove(workers.size() - 1);
    }
    
    /**
     * Method is used to add a room to a beehive.  When a room 
     * is added the method asks what kind of type the beehive is
     * and then adds 10 of that type of bee per room.
     */
    public String toString() {
        String hiveMess;
        if (beeType.equalsIgnoreCase(KILLTYPE)) {
            hiveMess = "Killer Bee Hive";
            
        } else if (beeType.equalsIgnoreCase(HONEYTYPE)) {
            hiveMess = "Honey Bee Hive";
        } else {
            hiveMess = "Basic Bee Hive";
        }
        return hiveMess;

    }
    
}
