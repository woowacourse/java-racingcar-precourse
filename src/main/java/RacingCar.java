/**
 * class : RacingCar.java
 *
 * version : 1.0
 *
 * date : 2019.04.01
 *
 * author : icarus8050
 */

import domain.Car;
import racing.CarListMaker;
import racing.InputValidation;

import java.util.List;
import java.util.Scanner;

/**
 * 레이싱 게임을 진행하는 메인 클래스
 */
public class RacingCar {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        List<Car> carList = CarListMaker.getList(inputCarList());
        int rumTime = inputRumTimeNumber();
        scanner.close();
    }

    /**
     * 경주할 자동차 이름 목록을 입력하는 메소드
     * @return  ","로 구분된 자동차 이름 목록
     */
    private static String inputCarList() {
        String stringBasedCarList;

        /* 유효한 자동차 이름 리스트를 입력될 때까지 루프 순회 */
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            stringBasedCarList = scanner.nextLine();
            if (InputValidation.inspectCarNames(stringBasedCarList)) {
                return  stringBasedCarList;
            }
        }
    }

    private static int inputRumTimeNumber() {
        String input;

        while (true) {
            System.out.println("시도할 횟수는 몇회인가요?");
            input = scanner.nextLine();
            if (InputValidation.inspectRuntimeNumber(input)) {
                return Integer.parseInt(input);
            }
        }
    }
}
