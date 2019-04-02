package domain;

public class Game {

    private Car[] cars;
    private Display display;

    public Game() {
        display = new Display();
    }

    public Car[] makeCars(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    public void goOneTurnForEachCar() {
        for (int i = 0; i < cars.length; i++) {
            int randomNum = cars[i].makeRandomNums();
            cars[i].increasePosition(randomNum);
            display.showResults(cars[i]);
        }
    }
}
