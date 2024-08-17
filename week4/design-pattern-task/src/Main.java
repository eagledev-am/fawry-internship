import task.Client;
import task.ClientAdapter;
import task.Original;

public class Main {
    public static void main(String[] args) {
        // old service
        Original original = new Original();
        System.out.println("Original without adapter ");

        System.out.println("originalInt : ");
        original.originalInt(10);

        System.out.println("originalDouble : ");
        original.originalDouble(10);

        System.out.println("originalChar : ");
        original.originalChar((char) 65);

        // Adapter
        Client client = new ClientAdapter();

        System.out.println("clientInt :");
        client.clientInt(10);

        System.out.println("clientDouble :");
        client.clientDouble(10);

        System.out.println("clientChar :");
        client.clientChar((char) 65);

    }
}