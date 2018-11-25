package decorator;

public class HoneyBee extends BeeDecorator {
    
    public HoneyBee(Bee newBee) {
        super(newBee);
    }

    public String getType() {
        
        return tempBee.getType() + ", Honey Bee";
    }
    
    public String getAttribute() {
        return tempBee.getAttribute() + ", Honey Comb Building";
    }

    
}
