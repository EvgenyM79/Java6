public class Del {

    public String str1, str2;

    public Del(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }

    public double del()throws MyException{
        try {
            return Integer.valueOf(str1)/Integer.valueOf(str2);
        }
        catch (NumberFormatException e){
            throw new MyException("N1" ,e);
            //System.out.println("0");
        }

    }


}
