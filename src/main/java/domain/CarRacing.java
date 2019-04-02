package domain;

import domain.handler.InputHandler;
import domain.handler.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final RandomNumGenerator randomNumGenerator;
    private final List<Car> carList;
    private int numOfMoves;

    public CarRacing() {
        inputHandler = new InputHandler();
        outputHandler = new OutputHandler();
        randomNumGenerator = new RandomNumGenerator();
        carList = new ArrayList<>();
    }

    public void play() {
        initGame();
        moveCars();
        showResult();
    }

    private void initGame() {
        setCarNames();
        setNumOfMoves();
    }

    private void moveCars() {
        System.out.println("\n실행 결과");

        while (numOfMoves > 0) {
            for (Car car : carList) {
                int random = randomNumGenerator.generateRandomNum();
                car.ForwardOrStop(random);
                outputHandler.printCarPosition(car);
            }
            System.out.println();           // 결과를 보기 편하도록
            numOfMoves--;
        }
    }

    private void showResult() {
        List<Car> winnerCars = getWinnerCars();

        outputHandler.printWinner(winnerCars);
    }

    private List<Car> getWinnerCars() {
        List<Car> winnerCars = new ArrayList<>();

        int longestPosition = getLongestPosition();
        for (Car car : carList) {
            if (longestPosition == car.getPosition()) {
                winnerCars.add(car);
            }
        }
        return winnerCars;
    }

    private int getLongestPosition() {
        int longestPosition = Integer.MIN_VALUE;
        for (Car car : carList) {
            int position = car.getPosition();
            if (longestPosition < position) {
                longestPosition = position;
            }
        }
        return longestPosition;
    }

    private void setCarNames() {
        String[] carNames = inputHandler.getCarNames();
        carList.clear();
        for (String carName : carNames) {
            carList.add(Car.createCarWithName(carName));
        }
    }

    private void setNumOfMoves() {
        numOfMoves = inputHandler.getNumOfMoves();
    }
}
