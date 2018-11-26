package builder;
import java.util.ArrayList;

import decorator.BasicBee;
import decorator.Bee;
import decorator.HoneyBee;
import decorator.QueenBee;

public class HoneyBuilder extends HiveBuilder{

    private Hive honeyHive = new Hive();
    private Bee honeyQueen = new QueenBee(new HoneyBee(new BasicBee()));
    private Bee honeyBees = new HoneyBee(new BasicBee());

    @Override
    public void beeType() {
        honeyHive.beeType = honeyBees.getType();

    }

    @Override
    public void beeAttribute() {
        honeyHive.beeAttribute = honeyBees.getAttribute();

    }

    @Override
    public void queen() {
        honeyHive.queen = honeyQueen;

    }

    @Override
    public void workers() {
        for (int i = 0; i < 350 ; i++){
            honeyHive.workers.add(honeyBees);
        }
    }

    @Override
    public void rooms() {
        honeyHive.rooms = 35;

    }

    @Override
    public Hive build() {

        return honeyHive;
    }

}


}
