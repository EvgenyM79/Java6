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
        CarsWR loadCar = new CarsWR();
        //List<String> listCar = loadCar.readCar();
        //System.out.println(listCar);
        //loadCar.readCar();

        MainGSM mGSM = new MainGSM(loadCar);
        //MainGSM mGSM = new MainGSM();
        mGSM.Init();
        System.out.println(mGSM.getCarRW().readCar().get(0));

        //для тесторивания
        //List<String> linesCar = null;
        /*CarUtils rCar = new CarUtils();
        rCar.returnArrayParam();
        rCar.returnArrayCar();
        rCar.calcAll();
        rCar.SortCar();*/
    }
}
