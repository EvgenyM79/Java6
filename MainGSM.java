import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;



public class MainGSM  {

    private ICarRW carRW;

    private Collection<MyCar> myCars;  //здесь лучше private и создать get/
    public Collection<CarParametrs> carParametrs;

    public MainGSM(ICarRW carRW) {
        this.carRW = carRW;
        System.out.println(carRW);
    }



    public void Init() throws IOException {
        try {
            carRW.readCar();
            System.out.println(carRW.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ICarRW getCarRW(){
        return carRW;
    }

    /*public String toString(){
        for (List<String> lineCar : carRW){

        }
        return carRW;
    }*/

    /*public interface ICarParamR{
        static void readCar(Object object) throws IOException {

            List<String> listParamsCar = Files.readAllLines(Paths.get("listParamsCars.txt"));
        }
    }*/





}

 

 