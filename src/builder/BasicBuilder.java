package builder;

import decorator.BasicBee;
import decorator.Bee;
import decorator.QueenBee;

public class BasicBuilder extends HiveBuilder {

    //private Hive basicHive = new Hive();
    private Bee basicQueen = new QueenBee(new BasicBee());
    private Bee basicBees = new BasicBee();

    @Override
    public void beeType() {
        hive.beeType = basicBees.getType();

    }

    @Override
    public void beeAttribute() {
        hive.beeAttribute = basicBees.getAttribute();

    }

    @Override
    public void queen() {
        hive.queen = basicQueen;

    }

    @Override
    public void workers() {
        for (int i = 0; i < 1000; i++) {
            hive.workers.add(new BasicBee());
        }
    }

    @Override
    public void rooms() {
        hive.rooms = 100;

    }


}


