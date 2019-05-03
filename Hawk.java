class eagle {
    {System.out.println("e1");}

    public eagle() {
        System.out.println("e2");
    }
}
class Bird extends eagle{
    {System.out.println("b1");}
   static {System.out.println("r1");}
    public Bird() {
        System.out.println("b2");
    }
    {System.out.println("b3");}
    static {System.out.println("r2");}
}

public class Hawk  extends Bird{
    public static void main(String[] args) {
        System.out.println("pre");
        new Hawk();
        System.out.println("hawk");
    }
}
