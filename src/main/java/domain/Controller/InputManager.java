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

    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return scanner.next();
    }

    public String[] inputCarNamesArray() {
        return inputCarNames().split(",");
    }

    public int inputNumberOfLaps() {
        int lap = -1;

        while(lap != 0) {
            System.out.println("시도할 횟수는 몇회인가요?");

            try {
                lap = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                System.out.println("숫자만 입력해주세요!!");
            }

        }


        return lap;
    }
}
