package builder;
import java.util.ArrayList;

import decorator.BasicBee;
import decorator.Bee;
import decorator.QueenBee;

public class BasicBuilder extends HiveBuilder{

    private Hive basicHive = new Hive();
    private Bee basicQueen = new QueenBee(new BasicBee());
    private Bee basicBees = new BasicBee();

    @Override
    public void beeType() {
        basicHive.beeType = basicBees.getType();

    }

    @Override
    public void beeAttribute() {
        basicHive.beeAttribute = basicBees.getAttribute();

    }

    @Override
    public void queen() {
        basicHive.queen = basicQueen;

    }

    @Override
    public void workers() {
        for (int i = 0; i < 1000 ; i++){
            basicHive.workers.add(basicBees);
        }
    }

    @Override
    public void rooms() {
        basicHive.rooms = 100;

    }

    @Override
    public Hive build() {

        return basicHive;
    }

}


}

