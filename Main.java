import javax.imageio.plugins.jpeg.JPEGQTable;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        FunctionLogging f1 = new FunctionLogging("");
        f1.writeToFile("mylogs.log","lucky","new message");
        System.out.println("3");
        System.out.println("5");
        System.out.println("7");
        FunctionLogging f2 = new FunctionLogging("", "21-12-2019.log");
        //f2.readFromFile("mylogs.log");
        f2.readFromFile("22-12-2019.log");
        System.out.println(f2.getLinesLog());
    }
}
