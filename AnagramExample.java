import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramExample {
    public static void main(String[] args) {
        String input = "HELLO"; //atca
        String output = "XYZVT";//atc,act,tca,tca
        Map<Character,Long> inputMap = new HashMap<>();
        inputMap = input.chars().mapToObj(x ->(char) x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        inputMap.forEach((k,v) ->System.out.println( "K: " + k + " V:" + v));

        System.out.println();
        Map<Character,Long> outputMap = new HashMap<>();
        outputMap = output.chars().mapToObj(x ->(char) x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        outputMap.forEach((k,v) ->System.out.println( "K: " + k + " V:" + v));
        Boolean isAnagram = inputMap.equals(outputMap);
        System.out.println("isAnagram "+ isAnagram);
    }
}
