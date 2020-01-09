/**Класс для создания файла person.dat в котором созданы несколько объектов Person c логином и паролем.
 *
 */

import java.io.*;
import java.util.Scanner;

public class Login {

    private Scanner sc = new Scanner(System.in);
    private String login;
    private String password;

    public void createUsers(String fUser, int size){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fUser))) {
            for (int i = 0; i < size; i ++){
                Person person = new Person("test" + i, "test" + i + i + i);
                objectOutputStream.writeObject(person);
            }
            System.out.println(size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
