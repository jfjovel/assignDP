package builder;

import decorator.BasicBee;
import decorator.Bee;
import decorator.KillerBee;
import decorator.QueenBee;

public class KillerBuilder extends HiveBuilder {
    
    //private Hive killerHive = new Hive();
    private Bee killerQueen = new QueenBee(new KillerBee(new BasicBee()));
    private Bee killerBees = new KillerBee(new BasicBee());

    @Override
    public void beeType() {
        hive.beeType = killerBees.getType();
        
    }

    @Override
    public void beeAttribute() {
        hive.beeAttribute = killerBees.getAttribute();
        
    }

    @Override
    public void queen() {
        hive.queen = killerQueen;
        
    }

    @Override
    public void workers() {
        for (int i = 0; i < 150; i++) {
            hive.workers.add(new KillerBee(new BasicBee()));
        }
        
    }

    @Override
    public void rooms() {
        hive.rooms = 15;
        
    }


}
