package racingcar;

import exception.IllegalLengthException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] carNames = getCarNames(scanner);
        // for debugging
        for (String carName : carNames) {
            System.out.println("name: " + carName);
        }
    }

    private static String[] getCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInputString;
        String[] carNames;

        try {
            carNamesInputString = scanner.next();
            carNames = carNamesInputString.split(",");
            if (!validateCarNameLength(carNames)) {
                throw new IllegalLengthException();
            }
        } catch (Exception e) {
            // TODO 에러사항 세분화 하기 : 중복 제거, Empty 처리하기
            System.out.println("[ERROR] 잘못된 입력값입니다.");
            throw new IllegalArgumentException();
        }

        return carNames;
    }

    private static boolean validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
