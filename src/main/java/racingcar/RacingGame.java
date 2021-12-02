package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class RacingGame {
    private int moves;
    ArrayList<Car> carArrayList = new ArrayList<>();

    public void run() {
        initGame();
        startGame();
    }

    private void initGame() {
        processCarName(inputCarNames());
        inputMoves();
    }

    private void startGame() {
        moveAllCar();
    }

    private void moveAllCar() {
        for(Car car : carArrayList) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if(canCarMove()) {
            car.moveCarForward();
        }
    }

    private boolean canCarMove() {
        return RandomNumberGenerator.getRandomNumber() >= 4;
    }

    private String inputCarNames() {
        return Console.readLine();
    }

    private void inputMoves() {
        moves = Integer.parseInt(Console.readLine());
    }

    private void processCarName(String carNames) {
        StringTokenizer st = new StringTokenizer(carNames, ",");

        while(st.hasMoreTokens()) {
            validateName(st.nextToken()); //try catch?
        }
    }

    private void validateName(String carName) {
        if(isValid(carName)) {
            throw new IllegalArgumentException();
        }

        carArrayList.add(new Car(carName));
    }

    private boolean isValid(String carName) {
        return carName.length() > 5;
    }
}
