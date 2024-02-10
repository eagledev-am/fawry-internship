package Problem;

/**
 * why to use singleton?
 * we use singleton to use only one object
 * but when we two threads use the method getInstance()
 * two objects are created which is shown in this package
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest());
        Thread thread1 = new Thread(new ThreadTest());

        // start
        thread1.start();
        thread.start();

    }
}