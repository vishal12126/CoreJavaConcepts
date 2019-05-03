import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//reference:-https://www.geeksforgeeks.org/functional-interfaces-java/
public class FunctionaInterfaceTest {
    public static void main(String[] args) {

        // create a list of strings
        List<String> names =
                Arrays.asList("Geek","GeeksQuiz","g1","QA","Geek2");

        // declare the predicate type as string and use
        // lambda expression to create object
        Predicate<String> p = (s)->s.startsWith("G");

        // Iterate through the list
        for (String st:names)
        {
            // call the test method
            if (p.test(st))
                System.out.println(st);
        }

        //Square
        // lambda expression to define the calculate method
        Square s = (int x)->x*x;

        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(5);
        System.out.println(ans);
        s.print();
    }
}

@FunctionalInterface
interface Square
{
    int calculate(int x);
    default void print(){
        System.out.println("In Functional Interface");
    }

}

