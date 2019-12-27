public enum ExceptionEnum {
    N1 ("NumberFormatException"),
    N2 ("IOException");
    private String error;

    ExceptionEnum(String error){
        this.error = error;
    }

    public String getTitle() {
        return error;
    }
}
