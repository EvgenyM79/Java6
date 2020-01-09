/** Класс - Основное меню:
 * 1. Производится проверка пользователяи его пароля.
 * 2. После удачной авторизации, открывается меню для выбора конктретного действия в программе
 * 3. Осуществляется логирование действий пользователя.
 */
import java.util.Scanner;

public class MyMenu {
    private final Scanner scanner;

    public MyMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printMenu() {
        System.out.println("1. Добавление авто;");
        System.out.println("2. Вывод итоговой информации");
        System.out.println("3. Выыод иформации по конкретному авто");
        System.out.println("q. Выход из приложения;");
    }

    public void start() {
        if (this.scanner != null) {
            String key;
            //Создание 5 пользователей для тестирования
            int size = 5;
            Login createLoginForTest = new Login();
            String fUser = "person.dat";
            createLoginForTest.createUsers(fUser,size);
            Person enter = new Person();
            //Проверка на существованипя такого логина и пароля в системе (проверка по файлу person.dat)
            FileWR loadwriteCar = new FileWR();
            FunctionLogging functionLogging = new FunctionLogging();
            try {
                functionLogging.writeToFile("","Start programm");
            }
            catch (MyException e) {
                System.out.println(ExceptionEnum.valueOf(e.p).getTitle());
            }
            if (enter.goodLogin(fUser, size)) {
                //Меню
                System.out.print("Вы вошли как: ");
                System.out.println(enter.getEnterLogin());
                try {
                    functionLogging.writeToFile(enter.getEnterLogin(),"Login");
                }
                catch (MyException e) {
                    System.out.println(ExceptionEnum.valueOf(e.p).getTitle());
                }
                do {
                    printMenu();
                    System.out.print("Введите номер меню: ");
                    //FileWR loadwriteCar = new FileWR();
                    MainGSM mGSM = new MainGSM(loadwriteCar);
                    key = this.scanner.nextLine();
                    switch (key) {
                        case "1":
                            System.out.print("Введите параметры (Вида C200_2-300-30):");
                            String newParam = scanner.nextLine();
                            try {
                                functionLogging.writeToFile(enter.getEnterLogin(),"Добавление информации об авто: " + newParam);
                            }
                            catch (MyException e) {
                                System.out.println(ExceptionEnum.valueOf(e.p).getTitle());
                            }
                            mGSM.addCar("listCar.txt", newParam);
                            break;
                        case "2":
                            try {
                                functionLogging.writeToFile(enter.getEnterLogin(),"Вывод итоговой информации:");
                            }
                            catch (MyException e) {
                                System.out.println(ExceptionEnum.valueOf(e.p).getTitle());
                            }
                            mGSM.Init("listCar.txt", "listParam.txt");
                            break;
                        case "3":
                            System.out.print("Введите модель для которой хотите получить информацию (Вида C200):");
                            String model = scanner.nextLine();
                            try {
                                functionLogging.writeToFile(enter.getEnterLogin(),"Вывод информации по модели авто:" + model);
                            }
                            catch (MyException e) {
                                System.out.println(ExceptionEnum.valueOf(e.p).getTitle());
                            }
                            mGSM.InitOneModelCar("listCar.txt", "listParam.txt", model);
                            break;
                        case "q":
                            System.out.println("Завершение программы...");
                            key = "q";
                            try {
                                functionLogging.writeToFile(enter.getEnterLogin(),"Выход из программы...");
                            }
                            catch (MyException e) {
                                System.out.println(ExceptionEnum.valueOf(e.p).getTitle());
                            }
                            break;
                        default:
                            System.out.println("Вы ввели неверное значение меню...\n");
                    }
                } while (key != "q");
            }
            else{
                System.out.println("Неверные данный для входа - принудительный выход");
                try {
                    functionLogging.writeToFile(enter.getEnterLogin(),"Неверные данные для входа - принудительный выход");
                }
                catch (MyException e) {
                    System.out.println(ExceptionEnum.valueOf(e.p).getTitle());
                }
            }
        }
    }
}
