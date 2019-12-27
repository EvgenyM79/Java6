import javax.imageio.plugins.jpeg.JPEGQTable;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, MyException {
	// write your code here
        MessageRW mRW = new MessageRW();
        FunctionLogging f1 = new FunctionLogging();
        //Добавление сообщения в лог файл
        try {
            f1.writeToFile("lucky","new message");
        }
        catch (MyException e) {
            System.out.println(ExceptionEnum.valueOf(e.errorException).getTitle());
        }
        f1.writeToFile("lucky","new message");
        FunctionLogging f2 = new FunctionLogging();
        //Вывод информации в разрезе каждого дня (например на 22.12.2019);
        f2.readFromFile("27-12-2019.log");
        f2.printLogDay("27-12-2019.log");
        //System.out.println(f2.getLinesLog());
        //Вывод информации в разрезе пользователя (например на 22.12.2019);
        f2.printLogUser("27-12-2019.log","lucky");
    }
}
