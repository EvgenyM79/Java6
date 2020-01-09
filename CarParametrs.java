/** Класс параметров по всем моделям.
 */

public class CarParametrs {

    private String model;
    private Double fuelConsumption, fuelPrice;

    CarParametrs(String model, Double fuelConsumption, Double fuelPrice){
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.fuelPrice = fuelPrice;
    }

    public String getModel(){
        return model;
    }

    public Double getFuelConsumption(){
        return fuelConsumption;
    }

    public Double getFuelPrice(){
        return fuelPrice;
    }

    @Override
    public String toString(){
        return "{model : " + model + "} {fuelConsumption : " + fuelConsumption + "} {fuelPrice : " + fuelPrice + "}";
    }

}
