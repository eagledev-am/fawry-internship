package task;

public class ClientAdapter extends Client{
    private Original original;

    public ClientAdapter(){
        original = new Original();
    }

    @Override
    public void clientDouble(double value) {
        original.originalDouble(value);
    }

    @Override
    public void clientInt(int value) {
        original.originalDouble(value * 2);
    }

    @Override
    public void clientChar(char character) {
        for(int i = 0;i<5;i++){
            original.originalChar(character);
        }
    }
}
