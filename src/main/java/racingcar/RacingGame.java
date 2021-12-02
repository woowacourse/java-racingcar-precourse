package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class RacingGame {
    private Result result;
    private int moves;
    ArrayList<Car> carArrayList = new ArrayList<>();

    public void run() {
        initGame();
        startGame();
    }

    private void initGame() {
        processCarName(inputCarNames());
        createResult();
        inputMoves();
    }

    private void createResult() {
        result = new Result(carArrayList);
    }

    private void startGame() {
        for(int i = 0; i < moves; i++) {
            moveAllCar();
            printResult();
        }
    }

    private void printResult() {
        System.out.println(result.toString());
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
