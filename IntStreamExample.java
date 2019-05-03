import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamExample {
    public static void main(String[] args) {

       // IntStream.rangeClosed(1,3).forEach(System.out::println);
       // IntStream.iterate(0, i -> 2).limit(3).forEach(System.out::println);

        LinkedList<String> slist = new LinkedList<>();
        slist.add("hello");
        slist.add("hi");
        slist.add("bye"); slist.add("more"); slist.add("hello");
       // slist.forEach(System.out::println);

        Boolean b = slist.removeFirstOccurrence("hello");
        //slist.forEach(System.out::println);

       ArrayList<String> sl = (ArrayList<String>) slist.stream().filter(e -> e.equals("hello")).map(x -> x.substring(1,3))
               .collect(Collectors.toList());
        sl.forEach(System.out::println);
    System.out.println(b + " Size :  " + sl.size());
    }
}
