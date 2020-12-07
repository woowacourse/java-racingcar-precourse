package racingcar;

import java.util.Scanner;

public class Racing {
    private int maximumPosition;
    private InputView inputView;
    private OutputView outputView;

    public void run(Scanner scanner) {
        inputView = new InputView();
        outputView = new OutputView();
        inputView.setCarNameList(scanner);
        inputView.setRoundCount(scanner);
        CarGroup carGroup = new CarGroup(inputView.getCarList());
        raceAllRound(carGroup, inputView.getRoundCount());
        setMaximumPosition(carGroup);
        outputView.printFinalWinner(carGroup.getFinalWinner(maximumPosition));
    }

    private void setMaximumPosition(CarGroup carGroup) {
        int currentPosition;
        for (Car car : carGroup.getCarGroup()) {
            currentPosition = car.getPosition();
            if (maximumPosition < currentPosition) {
                maximumPosition = currentPosition;
            }
        }
    }

    private void raceAllRound(CarGroup carGroup,int roundCount) {
        outputView.printRacingStartMessage();
        for (int i = 0; i < roundCount; i++) {
            carGroup.raceOneRound();
            outputView.printRoundResult(carGroup);
        }
    }
}
