package domain;

public class Game {

    private Car[] cars;

    public Car[] makeCars(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }
}
