package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 초기화에 대한 클래스
 *
 * @author Daeun Lee
 */
public class Initialization {
    public static ArrayList<Car> initCars(Scanner scanner) {
        OutputView.printCarNamesText();
        return InputView.scanCars(scanner);
    }

    public static int initTimes(Scanner scanner) {
        OutputView.printCarRacingTimesText();
        return InputView.scanTimes(scanner);
    }
}
