/** Интерфей для записи в файл м чтения из файла.
 */
        import java.io.IOException;
        import java.util.List;

public interface IFileRW {
        List<String> readFile(String filename) throws IOException;
        String writeFile(String fileName, String strCar) throws IOException;
}

