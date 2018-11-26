package builder;

public class HiveDirector {
    
    /**
     * Method is used to make the hive directly from a builder;
     * @param builder is the class that can instantiate the 
     *      new hive.
     */
    public void MakeHive(HiveBuilder builder) {
        builder.beeAttribute();
        builder.beeType();
        builder.queen();
        builder.workers();
        builder.rooms();
        
    }

}
