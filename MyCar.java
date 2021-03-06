public class MyCar {

    private String model;
    private Integer km, pBigAvto;
    private String gosNum;
    private Double prkm, cena;

    /*@Override
    public boolean equals(Object obj) {
        MyCar tmpCar = (MyCar) obj;
        return (this.model.equals(tmpCar.model)) && (this.gosNum.equals(tmpCar.gosNum));
    }*/

    public MyCar(String model, String gosNum, Integer km, Double prkm, Double cena, Integer pBigAvto){
        this.model = model;
        this.gosNum = gosNum;
        this.km = km;
        this.prkm = prkm;
        this.cena = cena;
        this.pBigAvto = pBigAvto;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getGosNum() {
        return gosNum;
    }
    public void setGosNum(String gosNum) {
        this.gosNum = gosNum;
    }
    @Override
    public String toString()	{
        return "{model : " + model + "} {gosNum : " + gosNum + "} {km : " + km + "} {prkm : " + prkm + "} {cena : " + cena + "} {pBigAvto : " + pBigAvto + "}";
    }
    public Integer getKm() {
        return km;
    }
    public void setKm(Integer model) {
        this.km = km;
    }
    public Integer getPBigAvto() {
        return pBigAvto;
    }
    public void setPBigAvto(Integer pBigAvto) {
        this.pBigAvto = pBigAvto;
    }

}
