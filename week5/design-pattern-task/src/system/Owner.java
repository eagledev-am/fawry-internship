package system;

public class Owner {
    private String name;
    private String message;

    public Owner(String name){
        this.name = name;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void receiveMessage(String message){
        this.setMessage(message);
    }
}
