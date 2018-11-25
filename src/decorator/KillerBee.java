package decorator;

public class KillerBee extends BeeDecorator {

    public KillerBee(Bee newBee) {
        super(newBee);
        
    }

    
    public String getType() {
        // TODO Auto-generated method stub
        return tempBee.getType() + ", Killer Bee";
    }
    
    public String getAttribute() {
        return tempBee.getAttribute() + ", Killing Strength";
        
    }

}
