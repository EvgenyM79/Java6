import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        //Меню
        //new MyMenu(new Scanner(System.in)).start();

        //Этот код перенести в MyMenu
        /*ICarRW carRW = null;
        MainGSM mGSM = new MainGSM(carRW);
        mGSM.Init();
        System.out.println(mGSM.getCarRW());*/

        //для тесторивания
        //List<String> linesCar = null;
        CarUtils rCar = new CarUtils();
        rCar.returnArrayParam();
        rCar.returnArrayCar();



    }
}
