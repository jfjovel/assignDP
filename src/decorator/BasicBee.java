package decorator;

public class BasicBee implements Bee {

    @Override
    public String getType() {
        return "Basic Drone Bee";
    }

    @Override
    public String getAttribute() {
        return "Pollen Gathering";
    }

}
