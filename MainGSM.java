/** Класс процедур вызываемый из меню.
 * - Добавление авто
 * - вывод общей информации
 * - Вывод по конкретной модели.
 */
import java.io.IOException;
import java.util.Collection;

public class MainGSM {

    private IFileRW carRW;

    private Collection<MyCar> myCars;
    public Collection<CarParametrs> carParametrs;

    public MainGSM(IFileRW carRW) {
        this.carRW = carRW;
    }

    public void Init(String fCar, String fParam){
        CarUtils rCar = new CarUtils();
        try {
            carParametrs = rCar.returnArrayParam(carRW.readFile(fParam));
            System.out.println(carParametrs);
            myCars = rCar.returnArrayCar(carRW.readFile(fCar));
            System.out.println(myCars);
            rCar.calcAll();
            rCar.SortCar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void InitOneModelCar(String fCar, String fParam, String model){
            CarUtils2 rOneCar = new CarUtils2();
        try {
            carParametrs = rOneCar.returnArrayParam(carRW.readFile(fParam));
            System.out.println(carParametrs);
            myCars = rOneCar.returnArrayCar(carRW.readFile(fCar), model);
            System.out.println(myCars);
            rOneCar.calcAll(model);
            rOneCar.SortCar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCar(String fCar, String newParamCar) {
        FileWR writeCar = new FileWR();
        try {
            writeCar.writeFile(fCar, newParamCar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

 

 