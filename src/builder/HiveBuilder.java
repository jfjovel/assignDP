package builder;

public abstract class HiveBuilder {
    protected Hive hive;
    
    public Hive getHive() {
        return hive;
    }
    
    public void createNewHive() {
        hive = new Hive();
    }

    public abstract void beeType();

    public abstract void beeAttribute();

    public abstract void queen();

    public abstract void workers();

    public abstract void rooms();

    //public abstract Hive build();



}
