import java.util.Arrays;
import java.util.Scanner;

public class MyMenu {
    private final Scanner scanner;

    public MyMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printMenu() {
        System.out.println("1. Добавление авто;");
        System.out.println("2. Создание массива из чисел Фибоначчи;");
        System.out.println("3. Создания двумерного массива;");
        System.out.println("q. Выход из приложения;");
    }

    public void start() {
        if (this.scanner != null) {
            String key;
            do {
                printMenu();
                System.out.print("Введите номер меню: ");
                key = this.scanner.nextLine();
                switch (key) {
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "q":
                        System.out.println("Завершение программы...");
                        key = "q";
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение меню...\n");
                }
            } while (key != "q");
        }
    }
}
