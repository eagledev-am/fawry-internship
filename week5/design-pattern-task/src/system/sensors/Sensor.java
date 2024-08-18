package system.sensors;

import system.Owner;
import system.action.Action;
import system.commands.Command;
import system.message.Message;
import system.util.Logger;

public abstract class Sensor {

    protected Command command;
    private String name;
    private String manufacturedCompany;

    protected Owner owner;
    protected Message message;
    protected Logger logger;

    public Sensor(String name , String manufacturedCompany , Owner owner){
        this.name = name;
        this.manufacturedCompany = manufacturedCompany;
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setManufacturedCompany(String manufacturedCompany) {
        this.manufacturedCompany = manufacturedCompany;
    }

    public String getManufacturedCompany() {
        return manufacturedCompany;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public abstract void detect(Action action);
    public abstract void turnOff(Action action);
}
