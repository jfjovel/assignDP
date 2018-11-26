package builder;

import java.util.ArrayList;

import decorator.BasicBee;
import decorator.Bee;
import decorator.HoneyBee;
import decorator.KillerBee;

public class Hive {
    private final String KILLTYPE = "Basic Drone Bee, Killer Bee";
    private final String HONEYTYPE = "Basic Drone Bee, Honey Bee";
    
    public String beeType;
    public String beeAttribute;
    public Bee queen;
    public ArrayList<Bee> workers = new ArrayList<Bee>();
    public int rooms;
    

    /**
     * @return the beeType
     */
    public String getBeeType() {
        return beeType;
    }

    /**
     * @return the beeAttribute
     */
    public String getBeeAttribute() {
        return beeAttribute;
    }

    /**
     * @return the queen
     */
    public Bee getQueen() {
        return queen;
    }

    /**
     * @return the workers
     */
    public ArrayList<Bee> getWorkers() {
        return workers;
    }

    /**
     * @return the rooms
     */
    public int getRooms() {
        return rooms;
    }
    
    public void addRoom(){
        rooms += 1;
        Bee temp;
        if (beeType.equalsIgnoreCase(KILLTYPE)) {
            temp = new KillerBee(new BasicBee());
            
        } else if (beeType.equalsIgnoreCase(HONEYTYPE)) {
            temp = new HoneyBee(new BasicBee());
        } else {
            temp = new BasicBee();
        }
        for (int i = 0; i<10; i++) {
            workers.add(temp);
        }
    }
    
    public void killBee(){
        workers.remove(workers.size() - 1);
    }
    
}
