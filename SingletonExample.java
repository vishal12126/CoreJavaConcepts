public class SingletonExample {
    public static void main(String[] args) {

        SingletonEx ex1 = SingletonEx.getInstance();
        ex1.doSomething();

        try {
            SingletonEx ex2 = (SingletonEx)ex1.clone();
            ex2.doSomething();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}

class SingletonEx implements Cloneable {
    private static SingletonEx instance;
    private SingletonEx(){
        System.out.println("Singleton(): Initializing Instance");
    }

    public static SingletonEx getInstance(){
        if(instance == null){
            synchronized (SingletonEx.class)
            {
                if(instance == null)
                {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new SingletonEx();
                }
            }

        }
        return instance;
    }

    public void doSomething()
    {
        System.out.println("doSomething(): Singleton does something!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}