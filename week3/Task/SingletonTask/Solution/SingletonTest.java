package Solution;

import Problem.SingletonEx;

public class SingletonTest {
    private static SingletonTest obj;

    private SingletonTest(){

    }

    public static SingletonTest getInstance(){
        if(obj == null){
            synchronized (SingletonTest.class){
                if(obj == null)
                    obj =  new SingletonTest();
            }
        }
        return obj;
    }
}
