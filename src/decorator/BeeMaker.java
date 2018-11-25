package decorator;

public class BeeMaker {
    
    public static void main(String[] args) {
        Bee baseBee = new BasicBee(); 
       
        System.out.println(baseBee.getType());
        System.out.println(baseBee.getAttribute());
        
        Bee queen = new QueenBee(new HoneyBee(new BasicBee()));
        
        System.out.println(queen.getType());
        System.out.println(queen.getAttribute());
        
        Bee honey = new HoneyBee(new BasicBee());
        
        System.out.println(honey.getType());
        System.out.println(honey.getAttribute());
        
        Bee killer = new KillerBee(new BasicBee());
        
        System.out.println(killer.getType());
        System.out.println(killer.getAttribute());
    }

    
    
    
}
