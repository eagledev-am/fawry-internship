package Solution;

public class ThreadTest implements Runnable{
    @Override
    public void run() {
        SingletonTest singletonEx = SingletonTest.getInstance();
        System.out.println(singletonEx);
    }
}