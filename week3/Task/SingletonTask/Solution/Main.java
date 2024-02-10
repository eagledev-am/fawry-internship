package Solution;
/**
 * We notice that only one object is created as
 * the address does not change
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest());
        Thread thread1 = new Thread(new ThreadTest());

        // start
        thread1.start();
        thread.start();

        SingletonTest singletonTest = SingletonTest.getInstance();
        System.out.println(singletonTest);
    }
}
