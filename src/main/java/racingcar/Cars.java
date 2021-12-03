package racingcar;

public class Cars implements ICars {
    private Car[] carArray;

    @Override
    public void createCar(String[] names){
        carArray = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            carArray[i] = new Car(names[i]);
        }
    }

    @Override
    public void moveCar(){
        for (int i = 0; i < carArray.length; i++) {
            carArray[i].pickRandomNumber();
        }
    }
}
