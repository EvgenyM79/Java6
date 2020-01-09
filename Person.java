/**Класс пользователей с зашифрованными паролями
 * Используется для:
 * - Создание обекта Person для последующего его записи в файл.
 * - Проверки введеного имени пользователя и пароля с данными из указанного файла.
 */

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Scanner;

public class Person implements Serializable {

    private String login, password;
    private String enterLogin;

    Person (String login, String password){
        this.login = login;
        this.password = encryptString(password);
    }

    Person (){};

    //Исключение данных из сериализации
    // private transient double height;

    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return decryptString(password);
    }

    public String getEnterLogin(){
        return enterLogin;
    }

    @Override
    public String toString()	{
        return "{Login : " + login + "} {password: " + decryptString(password) + "}";
    }

    private String encryptString(String data) {
        String encryptedData = Base64.getEncoder().encodeToString(data.getBytes());
        return encryptedData;
    }

    private String decryptString(String data) {
        String decrypted = new String(Base64.getDecoder().decode(data));
        return decrypted;
    }

    public Boolean goodLogin(String fUser, int size) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите login:");
        login =  sc.nextLine();
        System.out.print("Введите пароль:");
        password = sc.nextLine();
        System.out.println(login + " " + password);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fUser))) {
            Person p1;
            for (int i = 0; i < size; i++) {
                p1 = (Person) objectInputStream.readObject();
                System.out.print(p1);
                System.out.println(p1.getPassword());
                if (login.equals(p1.getLogin()) &&  password.equals(p1.getPassword())){
                    flag = true;
                    System.out.println(flag);
                    //this.enterLogin = login;
                }
                this.enterLogin = login;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return flag;
    }

}

