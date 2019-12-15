import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Scanner str1 = new Scanner(System.in);
        //List<String> lines = Arrays.asList("hello", "world");
        //Files.write(Paths.get("D:\\Java\\demo.txt"), lines, StandardOpenOption.CREATE);

        String[] masCar = new String[]{"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15", "C200_4-200-15"};
        String[] masVes = new String[]{"100,12.5,46.10,0", "200,12,48.90,0", "300,11.5,47.50,0", "400,20,48.90,0"};
        String[] st1 = new String[]{"C100_1", "C200_1", "C300_1"};
        String[] st2 = new String[]{"C100_1-100", "C200_1-120-1200", "C300_1-120-30"};
        HashMap<String, String> mapCar = new HashMap<>();
        mapCar.put(st1[0], st2[0]);
        mapCar.put(st1[1], st2[1]);
        mapCar.put(st1[2], st2[2]);
        System.out.println(mapCar);
        //Для записи файла
        //List<String> linesCar = Arrays.asList(masCar);
        //Files.write(Paths.get("D:\\Java\\listCar.txt"), linesCar, StandardOpenOption.CREATE);
        //List<String> linesVes = Arrays.asList(masVes);
        //Files.write(Paths.get("D:\\Java\\listVes.txt"), linesVes, StandardOpenOption.CREATE);
        List<String> linesCar2 = Files.readAllLines(Paths.get("D:\\Java\\listCar.txt"));
        System.out.println(linesCar2);
        for (String two : linesCar2) {
            System.out.println(two);
        }
        List<String> linesVes2 = Files.readAllLines(Paths.get("D:\\Java\\listVes.txt"));
        System.out.println(linesVes2);

        MyCar car3;
        HashMap<String, MyCar> mapCar2 = new HashMap<>();
        int i = 0;
        String[] masParCar;
        for (String two : linesCar2) {
            System.out.println(two);
            masParCar = two.split("[-_]+");
            car3 = new MyCar((masParCar[0].replaceFirst("C", "")), masParCar[1], Integer.parseInt(masParCar[2]), 100.0, 45.12, 0);
            System.out.println(car3);
            mapCar2.put((masParCar[0].replaceFirst("C", "")) + masParCar[1], car3);
        }

        System.out.println(mapCar2);

        // write your code here
    }
}
