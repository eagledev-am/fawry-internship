package system.devices;

public class Alarm implements Device{

    private static Alarm obj;
    private boolean turnedOn;

    private  Alarm(){

    }

    public static Device getInstance() {
        if(obj == null){
            obj = new Alarm();
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
        System.out.println("Alarm is turned on !");
    }

    @Override
    public void turnOff() {
        turnedOn = false;
        System.out.println("Alarm is turned off !");
    }
}
