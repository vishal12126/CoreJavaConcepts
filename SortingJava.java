import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortingJava {

    public static void main(String[] args) {

        int intArray[] = {1,4,2,5,7,89,100,343,12,32,67,89,59};

        int maxInt = Arrays.stream(intArray).filter(a -> a%2 == 0).max().orElse(-1);
       // System.out.println(maxInt);

        String characters = "ABCGSGJSUIBHGVGVA";
        String s = "ABCGS";
        int len = characters.length();

        HashMap<Character, Integer> map= new HashMap<Character, Integer>();
       /////JAVA 6
        for(int i=0;i < characters.length();i++){
            char c = characters.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                map.put(c, ++cnt);
            } else {
                map.put(c, 1);
            }
        }

        //IntStream.rangeClosed(1,s.length()).forEach(System.out::println);
        ///JAVA 8
        characters.chars().mapToObj(x ->(char) x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .forEach((k,v) -> System.out.println("CharactersJ8: " + k + " No. of OccurrenceJ8: "+ v));

       // map.forEach((k,v) -> System.out.println("Characters: " + k + " No. of Occurrence: "+ v));
    }
}
