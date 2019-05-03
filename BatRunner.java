import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;



public class BatRunner {
    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec(
                "cmd /c my.bat", null, new File("C:\\Users\\vishal.singh\\Desktop\\"));
    }
}