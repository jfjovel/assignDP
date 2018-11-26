package decorator;

import java.util.ArrayList;

public class BeeMaker {
    
    /**
     * basic main arguments.
     * @param args nothing to worry about.
     */
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

        System.out.println(killer.toString());
        ArrayList<Bee> bees = new ArrayList<Bee>();
        for(int i = 0; i < 5; i++){
            bees.add(killer);
        }
        System.out.println(bees.toString());
        bees.remove(killer);
        System.out.println(bees.toString());

    
    
    
    }
}
