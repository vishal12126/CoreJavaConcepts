import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReverseStringWithDots {

    public static void main(String[] args) {
      //  String s = "pqr.mnp";
        String s = "hello.i.am.here"; //"here.am.i.hello"
        ReverseStringWithDots rsv = new ReverseStringWithDots();
       String str = rsv.stringReverse(s);
        System.out.println(str);
    }
    public String stringReverse(String s){
        String [] imageNameArray = s.split("\\.");
        String f = "";
        for(int i =0; i< imageNameArray.length ; i++)
        {
            System.out.println(imageNameArray[i]);
        }
        for(int i =imageNameArray.length -1; i >= 0 ; i--)
        {
            f = f.concat(imageNameArray[i]+".");
        }
        int len = f.length();
        String str = f.substring(0,len-1);
        //here.am.i.hello
        return str;
    }
}
