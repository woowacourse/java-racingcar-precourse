package racingcar;

public class Game implements IGame{
    private Cars cars = new Cars();

    @Override
    public void startGame(String[] names, int count) {
        cars.createCar(names);

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            cars.moveCar();
            cars.printResult(i);

            System.out.println();
        }

        cars.getWinner();
    }
}
