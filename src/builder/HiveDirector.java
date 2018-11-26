package builder;

public class HiveDirector {
    
    private HiveBuilder builder;
    
    /**
     * Method is used to make the hive directly from a builder.
     */
    public void makeHive() {
        builder.createNewHive();
        builder.beeAttribute();
        builder.beeType();
        builder.queen();
        builder.workers();
        builder.rooms();
        
    }
    
    public void setBuilder(HiveBuilder hb) {
        builder = hb;
    }
    
    public Hive getHive() {
        return builder.getHive();
    }

}
