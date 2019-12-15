import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Del val = new Del("45", "3");
        try {
            System.out.println(val.del());
        }
        catch (MyException e) {
            System.out.println(ExceptionEnum.valueOf(e.p).getTitle());
        }
        //new MyMenu(new Scanner(System.in)).start();
        String[] masCar = new String[]{"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15", "C200_4-200-15"};
        double[][] masVes = new double[][]{{100, 12.5, 46.10, 0}, {200, 12, 48.90, 0}, {300, 11.5, 47.50, 0},{400, 20, 48.90, 0}};


    }
}
