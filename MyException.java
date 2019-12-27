public class MyException extends Exception {

    public String errorException;

    public MyException(String error, Throwable e){
        super(e);
        errorException = error;
    }
    public String getP(){
        return errorException;
    }

}
