public enum ExceptionEnum {
    N1 ("NumberFormatException"),
    N2 ("IOException"),
    N3 ("ArrayIndexOutOfBoundsException");
    private String errorException;

    ExceptionEnum(String error){
        this.errorException = error;
    }

    public String getTitle() {
        return errorException;
    }
}
