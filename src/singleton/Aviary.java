package singleton;

public class Aviary {
    private static Aviary onlyInstance = null;
    
    private Aviary(){
        
    }
    
    public static Aviary getInstance(){
        if(onlyInstance == null){
            onlyInstance = new Aviary();
        }
        return onlyInstance;
    }
}
