package builder;

import decorator.BasicBee;
import decorator.Bee;
import decorator.HoneyBee;
import decorator.QueenBee;

public class HoneyBuilder extends HiveBuilder {

    //private Hive honeyHive = new Hive();
    private Bee honeyQueen = new QueenBee(new HoneyBee(new BasicBee()));
    private Bee honeyBees = new HoneyBee(new BasicBee());

    @Override
    public void beeType() {
        hive.beeType = honeyBees.getType();

    }

    @Override
    public void beeAttribute() {
        hive.beeAttribute = honeyBees.getAttribute();

    }

    @Override
    public void queen() {
        hive.queen = honeyQueen;

    }

    @Override
    public void workers() {
        for (int i = 0; i < 350; i++) {
            hive.workers.add(new HoneyBee(new BasicBee()));
        }
    }

    @Override
    public void rooms() {
        hive.rooms = 35;

    }



}

