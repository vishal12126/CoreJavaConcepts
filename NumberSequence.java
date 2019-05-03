import java.util.ArrayList;
import java.util.List;

public class NumberSequence {

    public static void main(String[] args) {

        int[] num = {1,3,4,5,8};
        List<String> sList = new ArrayList<>();
        String s = null;
        for(int j=0;j<num.length;j++){
            System.out.println("hello");
            if(j < num.length) {
                System.out.println("hello -" +j);
                if (num[j + 1] - num[j] == 1) {
                    s = s + "\"" + num[j] + "\"";
                } else {
                    sList.add(String.valueOf(num[j]));
                }
                sList.add(s);
            }
        }

        sList.forEach(System.out::println);

    }
}
