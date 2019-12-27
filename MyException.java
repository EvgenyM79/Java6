public class MyException extends Exception {

    public String p;

    public MyException(String error, Throwable e){
        super(e);
        p = error;
    }
    public String getP(){
        return p;
    }

}
