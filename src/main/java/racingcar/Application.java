package racingcar;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Cars cars = new Cars();

        String[] nameList = user.inputCarName();
        int roundNumber = user.inputRoundNumber();

        cars.createCar(nameList);
        for (int i = 0; i < roundNumber; i++) {
            cars.moveCar();
            cars.printResult(i);
        }
        cars.getWinner();
    }
}
