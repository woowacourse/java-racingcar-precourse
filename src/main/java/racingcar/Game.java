package racingcar;

public class Game implements IGame{
    private Cars cars = new Cars();

    @Override
    public String startGame(String[] names, int count) {
        cars.createCar(names);

        for (int i = 0; i < count; i++) {
            cars.moveCar();
        }

        return null;
    }
}
