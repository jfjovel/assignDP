package decorator;

public class BeeMaker {
    
    public static void main(String[] args){
       Bee baseBee = new Drone(new BasicBee()); 
       
       System.out.println(baseBee.getType());
       System.out.println(baseBee.getAttribute());
    }

    
    
    
}
