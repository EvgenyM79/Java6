/** Список ошибок
 */
public enum ExceptionEnum {
    N1 ("NumberFormatException"),
    N2 ("IOException"),
    N3 ("ArrayIndexOutOfBoundsException");
    private String error;

    ExceptionEnum(String error){
        this.error = error;
    }

    public String getTitle() {
        return error;
    }
}
