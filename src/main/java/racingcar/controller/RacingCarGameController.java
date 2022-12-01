package racingcar.controller;

import racingcar.service.RacingCarGameService;
import racingcar.service.RacingCarGameValidateService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class RacingCarGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarGameService racingCarGameService = new RacingCarGameService();
    private final RacingCarGameValidateService racingCarGameValidateService = new RacingCarGameValidateService();

    private String carNames;
    private String tryNumber;

    public void gamePlay() {
        inputCarName();
        generateRacingCars();
        inputTryNumber();
        forwardTry();
        printForwardTryResult();
        printFinalWinners();
    }

    public void inputCarName() {
        outputView.printInputCarNameMessage();
        while (true) {
            try {
                carNames = inputView.inputCarName();
                racingCarGameValidateService.validateInputCarName(carNames);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void generateRacingCars() {
        racingCarGameService.generateRacingCars(carNames);
    }

    public void inputTryNumber() {
        outputView.printInputTryNumberMessage();
        while (true) {
            try {
                tryNumber = inputView.inputTryNumber();
                racingCarGameValidateService.validateInputTryNumber(tryNumber);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void forwardTry() {
        outputView.printGameResultMessage();
        for (int tryIndex = 0; tryIndex < Integer.parseInt(tryNumber); tryIndex++) {
            racingCarGameService.forwardTry();
            printForwardTryResult();
        }
    }

    public void printForwardTryResult() {
        List<Map<String, String>> forwardTryResult = racingCarGameService.getForwardTryResult();
        outputView.printForwardTryResult(forwardTryResult);
    }

    public void printFinalWinners() {
        List<String> finalWinners = racingCarGameService.getFinalWinner();
        outputView.printFinalWinners(finalWinners);
    }
}
