package system.sensors;

import system.Owner;
import system.action.Action;
import system.action.Smoke;
import system.commands.TurnOff;
import system.commands.TurnOn;
import system.devices.Device;
import system.devices.WaterSprinkler;
import system.message.SmsMessage;
import system.util.Logger;

import java.time.LocalDateTime;

public class SmokeSensor extends Sensor {
    private static Device device;

    public SmokeSensor(String name , String manufactured , Owner owner){
        super(name , manufactured , owner);
        device = WaterSprinkler.getInstance();
    }
    @Override
    public void detect(Action action) {
        if(action instanceof Smoke){
            if(!device.isTurnedOn()) {
                command = new TurnOn(device);
                command.execute();
                // send message to homeowner
                message = new SmsMessage();
                message.sendMessage("There is a detected smoke in the house ", owner);
                // log message to log file
                logger = Logger.getInstance();
                logger.log("Sensor turns on the Water Sprinkler at " + LocalDateTime.now());
            }
        }
    }

    @Override
    public void turnOff(Action action) {
        if(action instanceof Smoke) {
            if (device.isTurnedOn()) {
                command = new TurnOff(device);
                command.execute();
                logger = Logger.getInstance();
                logger.log("Sensor turns off the Water Sprinkler at " + LocalDateTime.now());
            }
        }
    }
}
