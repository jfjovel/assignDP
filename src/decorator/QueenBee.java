package decorator;

public class QueenBee extends BeeDecorator {

    public QueenBee(Bee newBee) {
        super(newBee);
        // TODO Auto-generated constructor stub
    }
    

    public String getType() {
        // TODO Auto-generated method stub
        return tempBee.getType() + ", Queen Bee";
    }
    
    public String getAttribute() {
        return tempBee.getAttribute() + ", +1 Baby Making, +1 Control, ";
    }

}
