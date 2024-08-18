package system.commands;

import system.devices.Device;

public class TurnOn implements Command{
    private Device device;

    public TurnOn(Device device){
        this.device = device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
