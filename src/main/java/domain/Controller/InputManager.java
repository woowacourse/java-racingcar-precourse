/**
 * InputManager.java 2019.12.07
 * <p>
 * version 1.0
 */
package domain.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Scanner로 입력받는 기능을 관리하는 클래스
 * 반복 횟수, 자동차의 이름을 입력 받는다.
 * 추가로 입력받은 자동차의 이름을 (,)를 기준으로
 * 자르는 메소드도 포함하고 있다.
 *
 * @author 황성찬
 * @version 1.0 2019-12-07
 */
public class InputManager {
    Scanner scanner;
    int ZERO = 0;
    int LAP_INITIALIZE = -1;
    int lap = LAP_INITIALIZE;

    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    public String inputCarNames() {
        String carNames;
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        carNames = scanner.nextLine();

        if (carNames.equals(",")) {
            System.out.println("(,)만 입력할 수 없습니다! 다시 입력해주세요.");
            return scanner.nextLine();
        }

        return carNames;
    }

    public String[] inputCarNamesArray() {
        return inputCarNames().split(",");
    }

    private boolean isLapInt() {

        try {
            this.lap = scanner.nextInt();
            return true;
        } catch (InputMismatchException e) {
            scanner = new Scanner(System.in);
            System.out.println("숫자만 입력해주세요!!");
            return false;
        }

    }

    private boolean isLapBiggerThanZero() {

        if (this.lap > ZERO) {
            return true;
        } else {
            System.out.println("0보다 큰 수를 입력하세요!");
            this.lap = LAP_INITIALIZE;
            return false;
        }

    }

    public int inputNumberOfLaps() {

        while(lap != ZERO) {
            System.out.println("시도할 횟수는 몇회인가요?");

            if (isLapInt() && isLapBiggerThanZero()) { break; }

        }

        return lap;
    }
}
