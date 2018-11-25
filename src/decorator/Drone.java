package decorator;

public class Drone extends BeeDecorator{
    
    public Drone(Bee newBee){
        super(newBee);
    }

    public String getType() {
        
        return tempBee.getType() + ", Drone";
    }
    
    public String getAttribute(){
        return tempBee.getAttribute() + "+1 Pollen Gathering";
    }

    
}
