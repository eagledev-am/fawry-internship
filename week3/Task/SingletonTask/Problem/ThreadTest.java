package Problem;

import Problem.SingletonEx;

public class ThreadTest implements Runnable{
    @Override
    public void run() {
        SingletonEx singletonEx = SingletonEx.getInstance();
        System.out.println(singletonEx);
    }
}
