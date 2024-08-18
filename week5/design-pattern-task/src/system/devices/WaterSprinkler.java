package system.devices;

public class WaterSprinkler implements Device{

    private static WaterSprinkler obj;
    private boolean turnedOn;

    private WaterSprinkler(){}

    public static Device getInstance() {
        if(obj == null){
            obj = new WaterSprinkler();
        }
        return obj;
    }

    @Override
    public boolean isTurnedOn() {
        return turnedOn;
    }

    @Override
    public void turnOn() {
        turnedOn = true;
        System.out.println("Water sprinkler is turned on !");
    }

    @Override
    public void turnOff() {
        turnedOn = false;
        System.out.println("Water sprinkler is turned off !");
    }
}
