package builder;

public class HiveDirector {
    
    public void MakeHive(HiveBuilder builder){
        builder.beeAttribute();
        builder.beeType();
        builder.queen();
        builder.workers();
        builder.rooms();
        
    }

}
