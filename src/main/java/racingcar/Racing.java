package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
    private int maximumPosition;
    private String finalWinner;
    private InputView inputView;
    private OutputView outputView;
    private CarGroup carGroup;

    public void run(Scanner scanner) {
        inputView = new InputView();
        outputView = new OutputView();
        inputView.setCarNameList(scanner);
        inputView.setRoundCount(scanner);
        carGroup = new CarGroup(inputView.getCarList());

        raceAllRound(inputView.getRoundCount());
        setMaximumPosition();
        setFinalWinner();
        outputView.printFinalWinner(finalWinner);
    }

    public void setFinalWinner() {
        List<String> finalWinnerList = new ArrayList<>();
        for (Car car : carGroup.getCarGroup()) {
            if (car.getPosition() == maximumPosition) {
                finalWinnerList.add(car.getName());
            }
        }
        finalWinner = String.join(", ", finalWinnerList);
    }

    private void setMaximumPosition() {
        int currentPosition;
        for (Car car : carGroup.getCarGroup()) {
            currentPosition = car.getPosition();
            if (maximumPosition < currentPosition) {
                maximumPosition = currentPosition;
            }
        }
    }

    private void raceAllRound(int roundCount) {
        outputView.printRacingStartMessage();
        for (int i = 0; i < roundCount; i++) {
            carGroup.raceOneRound();
            outputView.printRoundResult(carGroup);
        }
    }
}
