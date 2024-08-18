package system.message;

import system.Owner;

public class SmsMessage implements Message{
    @Override
    public void sendMessage(String message , Owner owner) {
        owner.receiveMessage(message);
        System.out.println("Sms Message : " + message);
    }
}
