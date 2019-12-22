import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CarsWR implements ICarRW {

    public CarsWR() {
    }

    @Override
    public List<String> readCar() throws IOException {
        List<String> test;
        //return Files.readAllLines(Paths.get("listCar.txt"));
        test = Files.readAllLines(Paths.get("listCar.txt"));
        System.out.println(test);
        return test;
    }
}
