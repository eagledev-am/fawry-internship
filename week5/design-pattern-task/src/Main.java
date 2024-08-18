import system.Owner;
import system.action.Action;
import system.action.Motion;
import system.action.Smoke;
import system.sensors.MotionSensor;
import system.sensors.Sensor;
import system.sensors.SmokeSensor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // sensors
        Owner owner = new Owner("A");
        Sensor sensor1 = new SmokeSensor("Smoke Sensor" , "company1",owner);
        Sensor sensor2 = new SmokeSensor("Smoke Sensor" , "company1",owner);
        Sensor sensor3 = new MotionSensor("Motion Sensor" , "company1",owner);
        Sensor sensor4 = new MotionSensor("Motion Sensor" , "company1",owner);

        // list
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(sensor1);
        sensors.add(sensor2);
        sensors.add(sensor3);
        sensors.add(sensor4);


        // fire
        Action action = new Smoke();
        Action action1 = new Motion();

        detectAction(action , sensors);
        detectAction(action1 , sensors);
        turnOffDevices(action , sensors);
        turnOffDevices(action1 , sensors);
    }

    public static void detectAction(Action action , List<Sensor> sensors){
        for (Sensor sensor : sensors) {
            sensor.detect(action);
        }
    }

    public static void turnOffDevices(Action action , List<Sensor>sensors){
        for (Sensor sensor : sensors) {
            sensor.turnOff(action);
        }
    }
}