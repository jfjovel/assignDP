package singleton;

public class Apiary {
    private static Apiary onlyInstance = null;
    
    private Apiary(){
        
    }
    
    public static Apiary getInstance(){
        if(onlyInstance == null){
            onlyInstance = new Apiary();
        }
        return onlyInstance;
    }
}
