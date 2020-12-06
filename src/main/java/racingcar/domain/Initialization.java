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
    /**
     * @param scanner 입력 값
     * @return 자동차를 원소로 가진 리스트
     */
    public static ArrayList<Car> initCars(Scanner scanner) {
        OutputView.printCarNamesText();
        return InputView.scanCars(scanner);
    }

    /**
     * @param scanner 입력 값
     * @return 자동차 경주 게임을 시도할 횟수
     */
    public static int initTimes(Scanner scanner) {
        OutputView.printCarRacingTimesText();
        return InputView.scanTimes(scanner);
    }
}
