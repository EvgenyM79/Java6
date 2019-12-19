import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CarsWR implements ICarRW {

    public CarsWR() {
    }

    @Override
    public List<String> readCar() throws IOException {
        return Files.readAllLines(Paths.get("listCar.txt"));
    }
}
