package decorator;

public abstract class BeeDecorator implements Bee{
    protected Bee tempBee;
    
    public BeeDecorator(Bee newBee){
        tempBee = newBee;
    }
    
    public String getDescription(){
        return tempBee.getType();
    }

    public String getAttribute(){
        return tempBee.getAttribute();
    }
}
