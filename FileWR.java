/** Класс для чтения из файла и записи в файл.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileWR implements IFileRW {

    public FileWR() {
    }

    @Override
    public List<String> readFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    @Override
    public String writeFile(String fileName, String message) throws IOException{
        Files.write(Paths.get("" + fileName), Arrays.asList(message), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        return null;
    }
}
