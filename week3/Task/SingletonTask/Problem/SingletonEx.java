package Problem;

public class SingletonEx {
    private static SingletonEx obj;

    private SingletonEx(){

    }

    public static SingletonEx getInstance(){
        if(obj == null)
            return new SingletonEx();
        return obj;
    }


}
