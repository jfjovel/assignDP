package builder;

import decorator.Bee;

public abstract class HiveBuilder {
//    public String beeType;
//    public String beeAttribute;
//    public Bee queen;
//    public Bee[] workers;
//    public int rooms;

    public abstract void beeType();

    public abstract void beeAttribute();

    public abstract void queen();

    public abstract void workers();

    public abstract void rooms();

    public abstract Hive build();



}
