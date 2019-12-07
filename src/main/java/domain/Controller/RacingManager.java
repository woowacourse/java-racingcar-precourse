/**
 * RacingManager.java 2019.12.07
 * <p>
 * version 1.0
 */
package domain.Controller;

import java.util.Random;

/**
 * 자동차 경주 게임의 전반적인 진행과 예외처리를 담당하는 클래스
 * 기능은 다음과 같다.
 * 1. 자동차의 이름이 6글자 이상일 경우 재입력을 명령한다.
 * 2. 랜덤 숫자를 발생시켜 CarManager에게 제공한다. (특정조건검사)
 * 3. 매 바퀴마다 진행상황을 출력한다.
 * 4. Manager Class 들에게 입력과 입력값 할당을 명령한다.
 *
 * @version 1.0 2019-12-07
 * @author 황성찬
 */
public class RacingManager {
    private InputManager inputmanager;
    private CarManager carmanager;
    private Random random;
    private String[] carNamesArray;
    private int numberOfLaps;

    public RacingManager() {
        inputmanager = new InputManager();
        random = new Random();
    }

    private boolean isNamesLengthGraterThanFive
            (String[] carName) {
        for (String splitedCarNames : carName) {
            if (splitedCarNames.length() > 5) {
                System.out.println("자동차 이름을 5자 이하로 입력하세요!!");
                return true;
            }
        }
        return false;
    }

    private void moveOrStop() {
        for (int i = 0; i < numberOfLaps; i++) {
            for (int j = 0; j < carmanager.getCarsLength(); j++) {
                carmanager
                        .ifBiggerThanFourYouCanMove(random.nextInt(10), j);
            }
            printResultEachLap();
        }
    }

    private void printResultEachLap() {
        carmanager.printCarsNameAndPosition();
        System.out.println();
    }

    private void race() {
        moveOrStop();
        printResultEachLap();
    }

    private void printWinner() {
        carmanager.whoIsWinner();
    }

    private void carSetting() {
        do {
            this.carNamesArray = inputmanager.inputCarNamesArray();
        } while (isNamesLengthGraterThanFive(carNamesArray));
        carmanager = new CarManager(carNamesArray);
    }

    private void lapSetting() {
        this.numberOfLaps = inputmanager.inputNumberOfLaps();
    }

    public void start() {
        carSetting();
        lapSetting();
        race();
        printWinner();
    }
}
