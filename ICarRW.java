import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.List;

public interface ICarRW {
        List<String> readCar() throws IOException;
}

