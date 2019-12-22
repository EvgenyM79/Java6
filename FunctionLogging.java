import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FunctionLogging{

    private String path, nameFile;
    //SimpleDateFormat date;
    private List<String> linesLog;
    private String login, messageLog;
    private SimpleDateFormat dateTimelog = new SimpleDateFormat("dd-MM-yyyy|HH:mm:ss|");
    private SimpleDateFormat dateLog = new SimpleDateFormat("dd-MM-yyyy");

    public FunctionLogging(SimpleDateFormat dateTimelog, String login, String messageLog){
        this.dateTimelog = dateTimelog;
        this.login = login;
        this.messageLog = messageLog;
     }

    public FunctionLogging(String filePath, String nameFileLog){
        path = filePath;
        nameFile = nameFileLog;
    }

    public FunctionLogging(String filePath){
        path = filePath;
    }


    public void writeToFile(String nameFileLog, String login, String messageLog) throws IOException {
        Date dateNewLog = new Date();
        String timeStamp = dateTimelog.format(dateNewLog);
        String dateFiles = dateLog.format(dateNewLog);
        try {
            Files.write(Paths.get(path + dateFiles + ".log"), Arrays.asList(timeStamp + "login:" + login + "|" + messageLog) , StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            //Files.write(Paths.get(nameFileLog), Arrays.asList(timeStamp + "login:" + login + "|" + messageLog) , StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        catch (IOException e) {
        e.printStackTrace();
        }
    }

    public void readFromFile(String nameFileLog) throws IOException {
        try {
            Files.readAllLines(Paths.get(nameFileLog));
            linesLog = Files.readAllLines(Paths.get(nameFileLog));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getLinesLog(){
        return linesLog;
    }
}
