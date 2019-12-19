import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CarUtils {

    private MyCar car3;
    private CarParametrs carParams;
    private List<String> linesCar, linesParam;
    private ArrayList<MyCar> listCar = new ArrayList<>();
    private ArrayList<CarParametrs> listParams = new ArrayList<>();

    public ArrayList<CarParametrs> returnArrayParam() throws IOException {
        List<String> linesParams = Files.readAllLines(Paths.get("listParam.txt"));
        System.out.println(linesParams);
        CarParametrs carParams;
        ArrayList<CarParametrs> listParams = new ArrayList<>();
        String[] masParCar;
        for (String lineParam : linesParams) {
            masParCar = lineParam.split(",");
            carParams = new CarParametrs(masParCar[0], Double.valueOf(masParCar[1]), Double.valueOf(masParCar[2]));
            System.out.println(carParams);
            listParams.add(carParams);
        }
        System.out.println(listParams);
        return listParams;
    }

    public ArrayList<MyCar> returnArrayCar() throws IOException {
        //для тесторивания сделано чтение файла
        List<String> linesCars = Files.readAllLines(Paths.get("listCar.txt"));
        System.out.println(linesCars);
        MyCar car3;
        ArrayList<MyCar> arrayCar = new ArrayList<>();
        String[] masParCar;
        int tmpPBigAvto = 0;
        for (String linecar : linesCars) {
            masParCar = linecar.split("[-_]+");
            if (masParCar[0].equals("C100"))
                tmpPBigAvto = 0;
            else
                tmpPBigAvto = Integer.parseInt(masParCar[3]);
            car3 = new MyCar((masParCar[0].replaceFirst("C", "")), masParCar[1], Integer.parseInt(masParCar[2]), tmpPBigAvto);
            System.out.println(car3);
            if (!arrayCar.contains(car3))
                arrayCar.add(car3);
            else{
                ListIterator<MyCar> iterator = arrayCar.listIterator();
                while (iterator.hasNext()) {
                    MyCar next = iterator.next();
                    if (next.equals(car3)){
                        //Replace element
                        System.out.println(iterator.nextIndex()-1 + " " + arrayCar.get(iterator.nextIndex()-1).getKm() + " + " + car3.getKm() );
                        System.out.println(iterator.nextIndex()-1 + " " + arrayCar.get(iterator.nextIndex()-1).getPBigAvto() + " + " + car3.getPBigAvto() );
                        car3.setKm(arrayCar.get(iterator.nextIndex()-1).getKm() + car3.getKm());
                        car3.setPBigAvto(arrayCar.get(iterator.nextIndex()-1).getPBigAvto() + car3.getPBigAvto());
                        iterator.set(car3);
                        System.out.println(car3);
                    }
                }
            }
        }
        System.out.println(arrayCar);
        return arrayCar;
    }

    public void showCar(){
    }

}
