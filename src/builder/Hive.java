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
        Bee temp;
        if (beeType.equalsIgnoreCase(KILLTYPE)) {
            temp = new KillerBee(new BasicBee());
            
        } else if (beeType.equalsIgnoreCase(HONEYTYPE)) {
            temp = new HoneyBee(new BasicBee());
        } else {
            temp = new BasicBee();
        }
        for (int i = 0; i < 10; i++) {
            workers.add(temp);
        }
    }
    
    /**
     * Method is used to remove a bee from the hive when it is killed.
     */
    public void killBee() {
        workers.remove(workers.size() - 1);
    }
    
}
