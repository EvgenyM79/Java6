import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class MessageRW implements IMassegeRW{

    public MessageRW() {
    }

    @Override
    public List<String> readMessage(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    @Override
    public String writeMessage(String fileName, String message) throws IOException {
        Files.write(Paths.get("" + fileName), Arrays.asList(message), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        return null;
    }

}
