package domain;

public class Config {

    public String[] splitName(String name){
        String[] nameArray = name.split(",");
        return nameArray;
    }
    public Boolean checkNameNumber(String[] nameArray){
        for(int i=0; i<nameArray.length; i++){
            if(nameArray[i].length()>5) {
                return false;
            }
        }
        return true;
    }
    public Car[] makeGarage(String[] carArrays) {
        int length = carArrays.length;
        Car[] garage = new Car[length];
        for (int i = 0; i < length; i++) {
            garage[i] = new Car(carArrays[i]);
        }
        return garage;
    }
}
