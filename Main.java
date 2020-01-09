/** - Main основная программа для запуска.
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //Меню
        new MyMenu(new Scanner(System.in)).start();
     }
}
