package system.sensors;

import system.Owner;
import system.action.Action;
import system.action.Motion;
import system.commands.TurnOff;
import system.commands.TurnOn;
import system.devices.Alarm;
import system.devices.Device;
import system.message.SmsMessage;
import system.util.Logger;

import java.time.LocalDateTime;

public class MotionSensor extends Sensor{
    private static Device device;

    public MotionSensor(String name , String manufactured , Owner owner){
        super(name , manufactured , owner);
        device = Alarm.getInstance();
    }

    @Override
    public void detect(Action action) {
        if(action instanceof Motion)
        {
            if(!device.isTurnedOn()) {
                command = new TurnOn(device);
                command.execute();

                message = new SmsMessage();
                message.sendMessage("There is a detected motion in the house ", owner);

                logger = Logger.getInstance();
                logger.log("Sensor turned on the Alarm at " + LocalDateTime.now());
            }
        }
    }

    @Override
    public void turnOff(Action action) {
        if(action instanceof Motion)
        {
            if(device.isTurnedOn()) {
                command = new TurnOff(device);
                command.execute();
                logger = Logger.getInstance();
                logger.log("Sensor turned on the Alarm at " + LocalDateTime.now());
            }
        }
    }
}
