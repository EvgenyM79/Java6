import java.io.IOException;
import java.util.List;

public interface IMassegeRW {
        List<String> readMessage(String fileName) throws IOException;
        String writeMessage(String fileName, String message) throws IOException;
}
