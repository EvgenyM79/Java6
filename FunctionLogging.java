import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FunctionLogging{

    private List<String> linesLog;
    private SimpleDateFormat dateTimelog = new SimpleDateFormat("dd-MM-yyyy|HH:mm:ss|");
    private SimpleDateFormat dateLog = new SimpleDateFormat("dd-MM-yyyy");

    public void writeToFile(String login, String messageLog) throws MyException {
        Date dateNewLog = new Date();
        String timeStamp = dateTimelog.format(dateNewLog);
        String dateFiles = dateLog.format(dateNewLog);
        MessageRW mRW = new MessageRW();
        try {
            mRW.writeMessage(dateFiles + ".log", timeStamp + login + "|" + messageLog);
        }
        catch (IOException e){
            System.out.println(ExceptionEnum.valueOf(e.getMessage()).getTitle());
        }
    }

    public void readFromFile(String nameFileLog) throws MyException {
        MessageRW mRW = new MessageRW();
        try {
            linesLog = mRW.readMessage(nameFileLog);
        }
        catch (IOException e){
            System.out.println(ExceptionEnum.valueOf(e.getMessage()).getTitle());
        }
    }

    /*public List<String> getLinesLog(){
        return linesLog;
    }*/

    public void printLogDay(String nameFileLog) throws IOException {
        linesLog = Files.readAllLines(Paths.get(nameFileLog));
        System.out.println("Вывод сообщений в разрезе на дату " + linesLog.get(0).split("\\|")[0]);
        for (String log: linesLog){
                System.out.println(log);
        }
    }

    public void printLogUser(String nameFileLog, String user) throws IOException, MyException {
        linesLog = Files.readAllLines(Paths.get(nameFileLog));
        System.out.println("Вывод сообщений в разрезе пользователя: " + user + " на дату " + linesLog.get(0).split("\\|")[0]);
        for (String log: linesLog){
            try{
                if (log.split("\\|")[2].equals(user))
                    System.out.println(log);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                //throw e;
                //System.out.println(ExceptionEnum.valueOf(e.errorException).getTitle());
            }
        }
    }

}
