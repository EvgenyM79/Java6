import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] masCar = new String[]{"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15", "C200_4-200-15"};
        double[][] masVes = new double[][]{{100, 12.5, 46.10, 0}, {200, 12, 48.90, 0}, {300, 11.5, 47.50, 0},{400, 20, 48.90, 0}};
        String[] masParCar = masCar[0].substring(1).split("[-_]+"); //Инициализация переменной для разложение (например "200_1-120-1200) на все параметры одной машины
        ArrayList<TempCar> listCar = new ArrayList<>();
        TempCar tmpCar;
        int tmpPBigAvto = 0;
        for (int i = 0; i < masCar.length; i++) {
            masParCar = masCar[i].split("[-_]+");
            if (masParCar[0].equals("C100"))
                tmpPBigAvto = 0;
            else
                tmpPBigAvto = Integer.parseInt(masParCar[3]);
            tmpCar = new TempCar(Integer.parseInt(masParCar[0].replaceFirst("C", "")), masParCar[1],
                    Integer.parseInt(masParCar[2]), masVes[0][1], masVes[0][2], tmpPBigAvto);
            if (!listCar.contains(tmpCar))
                listCar.add(tmpCar);
            else{
                ListIterator<TempCar> iterator = listCar.listIterator();
                while (iterator.hasNext()) {
                    TempCar next = iterator.next();
                    if (next.equals(tmpCar)){
                        //Replace element
                        System.out.println(iterator.nextIndex()-1 + " " + listCar.get(iterator.nextIndex()-1).km + " + " + tmpCar.km );
                        System.out.println(iterator.nextIndex()-1 + " " + listCar.get(iterator.nextIndex()-1).pBigAvto + " + " + tmpCar.pBigAvto );
                        tmpCar.km += listCar.get(iterator.nextIndex()-1).km;
                        tmpCar.pBigAvto += listCar.get(iterator.nextIndex()-1).pBigAvto;
                        iterator.set(tmpCar);
                    }
                }
            }
            System.out.println("М:"+ tmpCar.model + " Гос№:" + tmpCar.gosNum + " Пр: " + tmpCar.km +  " расход:" + tmpCar.prkm + " цена:" + tmpCar.cena + " доп пр: " + tmpCar.pBigAvto);
        }
        System.out.println("ArrayList без дублей");
        for (TempCar car : listCar){
            System.out.println("М:"+ car.model + " Гос№:" + car.gosNum + " Пр: " + car.km +  " расход:" + car.prkm + " цена:" + car.cena + " доп пр: " + car.pBigAvto);
        }
        ClassCalc.calcAll(listCar);
        listCar.sort(new Comparator<TempCar>() {
            @Override
            public int compare(TempCar o1, TempCar o2) {
                return o1.km.compareTo(o2.km);

            }
        });
        System.out.println("ArrayList отсортированный по пробегу ");
        for (TempCar car : listCar){
            System.out.println("М:"+ car.model + " Гос№:" + car.gosNum + " Пр: " + car.km +  " расход:" + car.prkm + " цена:" + car.cena + " доп пр: " + car.pBigAvto);
        }

        listCar.sort(new Comparator<TempCar>() {
            @Override
            public int compare(TempCar o1, TempCar o2) {
                return o1.pBigAvto.compareTo(o2.pBigAvto) + o1.km.compareTo(o2.km);

            }
        });
        System.out.println("ArrayList отсортированный по пробегу и доп. параметру ");
        for (TempCar car : listCar){
            System.out.println("М:"+ car.model + " Гос№:" + car.gosNum + " Пр: " + car.km +  " расход:" + car.prkm + " цена:" + car.cena + " доп пр: " + car.pBigAvto);
        }
    }
}



