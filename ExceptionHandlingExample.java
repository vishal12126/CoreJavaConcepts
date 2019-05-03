import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExceptionHandlingExample {
    public static void main(String[] args){


        int x =0;

        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);

        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        myList.forEach(System.out::println);

        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

        int[] i = new int[3];
        String[] s = {"1","2"};

        try {
            if(x == 0)
                throw new myException("my exception from throw");
            System.out.println(x);
        } catch (myException e) {
            e.printStackTrace();
        } finally {
           // System.out.println("hello");
        }
    }
}

class myException extends Exception {

    public myException(String message) {
        super(message + "xyz");
    }
}