package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
    private List<String> finalwinnerNameList;
    private int maximumPosition;
    private List<Car> carList;
    private InputView inputView;
    private OutputView outputView;

    public void run(Scanner scanner) {
        inputView = new InputView(scanner);
        inputView.setCarNameList();
        inputView.setRacingCount();

        outputView = new OutputView(this);
        setCarList();
        raceAllRound();

        setFinalWinnerNameList();
        outputView.printFinalWinner(finalwinnerNameList);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setFinalWinnerNameList() {
        setMaximumPosition();
        finalwinnerNameList = new ArrayList<>();
        Car currentCar;
        for (Car car : carList) {
            currentCar = car;
            if (currentCar.getPosition() >= maximumPosition) {
                finalwinnerNameList.add(currentCar.getName());
            }
        }
    }

    private void setMaximumPosition() {
        int currentPosition;
        for (Car car : carList) {
            currentPosition = car.getPosition();
            if (maximumPosition < currentPosition) {
                maximumPosition = currentPosition;
            }
        }
    }

    private void raceAllRound() {
        outputView.printRacingStartMessage();
        for (int i = 0; i < inputView.getRacingCount(); i++) {
            raceOneRound();
            outputView.printRoundResult();
        }
    }

    private void raceOneRound() {
        for (Car car : carList) {
            car.moveForwardOrStop();
        }
    }

    public void setCarList() {
        carList = new ArrayList<>();
        for (String carName : inputView.getCarNameList()) {
            carList.add(new Car(carName));
        }
    }
}
