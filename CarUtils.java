import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CarUtils {

    private ArrayList<MyCar> listCar = new ArrayList<>();
    private ArrayList<CarParametrs> listParams = new ArrayList<>();

    public ArrayList<CarParametrs> returnArrayParam() throws IOException {
        List<String> linesParams = Files.readAllLines(Paths.get("listParam.txt"));
        System.out.println(linesParams);
        CarParametrs carParams;
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
            if (!listCar.contains(car3))
                listCar.add(car3);
            else{
                ListIterator<MyCar> iterator = listCar.listIterator();
                while (iterator.hasNext()) {
                    MyCar next = iterator.next();
                    if (next.equals(car3)){
                        //Replace element
                        System.out.println(iterator.nextIndex()-1 + " " + listCar.get(iterator.nextIndex()-1).getKm() + " + " + car3.getKm() );
                        System.out.println(iterator.nextIndex()-1 + " " + listCar.get(iterator.nextIndex()-1).getPBigAvto() + " + " + car3.getPBigAvto() );
                        car3.setKm(listCar.get(iterator.nextIndex()-1).getKm() + car3.getKm());
                        car3.setPBigAvto(listCar.get(iterator.nextIndex()-1).getPBigAvto() + car3.getPBigAvto());
                        iterator.set(car3);
                        System.out.println(car3);
                    }
                }
            }
        }
        System.out.println(listCar);
        return listCar;
    }

    public void SortCar(){

        System.out.println("ArrayList без дублей");
        for (MyCar car : listCar){
            System.out.println("М:"+ car.getModel() + " Гос№:" + car.getGosNum() + " Пр: " + car.getKm() + " доп пр: " + car.getPBigAvto());
        }
        listCar.sort(new Comparator<MyCar>() {
            @Override
            public int compare(MyCar o1, MyCar o2) {
                return o1.getKm().compareTo(o2.getKm());

            }
        });
        System.out.println("ArrayList отсортированный по пробегу ");
        for (MyCar car : listCar){
            System.out.println("М:"+ car.getModel() + " Гос№:" + car.getGosNum() + " Пр: " + car.getKm() + " доп пр: " + car.getPBigAvto());
        }

        listCar.sort(new Comparator<MyCar>() {
            @Override
            public int compare(MyCar o1, MyCar o2) {
                return o1.getPBigAvto().compareTo(o2.getPBigAvto()) + o1.getKm().compareTo(o2.getKm());
            }
        });
        System.out.println("ArrayList отсортированный по пробегу и доп. параметру ");
        for (MyCar car : listCar){
            System.out.println("М:"+ car.getModel() + " Гос№:" + car.getGosNum() + " Пр: " + car.getKm() + " доп пр: " + car.getPBigAvto());
        }
    }

    public void calcAll(){
        double[] allkm = {0,0,0,0};
        TreeMap<Double, Integer> map2 = new TreeMap<Double, Integer>();
        //TempCar chCar = new TempCar(0, "",0,0.0,0.0,0);

        for (MyCar car : listCar) {
            switch (car.getModel()) {
                case "100": {
                    allkm[0] += car.getKm() * listParams.get(0).getFuelConsumption() * listParams.get(0).getFuelPrice() / 100;
                    break;
                }
                case "200": {
                    allkm[1] += car.getKm() * listParams.get(1).getFuelConsumption() * listParams.get(1).getFuelPrice() / 100;
                    break;
                }
                case "300": {
                    allkm[2] +=  car.getKm() * listParams.get(2).getFuelConsumption() * listParams.get(2).getFuelPrice() / 100;
                    break;
                }
                case "400": {
                    allkm[3] +=  car.getKm() * listParams.get(3).getFuelConsumption() * listParams.get(3).getFuelPrice() / 100;
                    break;
                }
            }
        }
        System.out.println("Расход для легковых авто(C100) составил " + allkm[0]);
        System.out.println("Расход для грузовых авто(C200) составил " + allkm[1]);
        System.out.println("Расход для посажирских авто(C300) составил " + allkm[2]);
        System.out.println("Расход для тяжелой техники (краны)(C400) составил " + allkm[3]);
        System.out.println("Общий расход составил " + (allkm[0] +allkm[1] + allkm[2] + allkm[3]));

        for (int i = 0; i < 4; i ++) {
            map2.put(allkm[i], (i+1)*100);
        }
        System.out.println(map2);
        System.out.print("Тип авто " + map2.get(map2.firstKey()));
        System.out.println(" с наименьшей стоимостью расходов " + map2.firstKey());
        System.out.print("Тип авто " + map2.get(map2.lastKey()));
        System.out.println(" с наибольшей стоимость расходов " + map2.lastKey());
    }

}
