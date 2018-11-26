package builder;

import decorator.BasicBee;
import decorator.Bee;
import decorator.KillerBee;
import decorator.QueenBee;

public class KillerBuilder extends HiveBuilder{
    
    private Hive killerHive = new Hive();
    private Bee killerQueen = new QueenBee(new KillerBee(new BasicBee()));
    private Bee killerBees = new KillerBee(new BasicBee());

    @Override
    public void beeType() {
        killerHive.beeType = killerBees.getType();
        
    }

    @Override
    public void beeAttribute() {
        killerHive.beeAttribute = killerBees.getAttribute();
        
    }

    @Override
    public void queen() {
        killerHive.queen = killerQueen;
        
    }

    @Override
    public void workers() {
        for (int i = 0; i < 150 ; i++){
            killerHive.workers.add(killerBees);
        }
        
    }

    @Override
    public void rooms() {
        killerHive.rooms = 15;
        
    }

    @Override
    public Hive build() {
        
        return killerHive;
    }

}
