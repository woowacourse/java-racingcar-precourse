package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] carNames = getCarNames(scanner);
    }
    private static String[] getCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInputString;
        String[] carNames;

        try {
            carNamesInputString = scanner.next();
            carNames = carNamesInputString.split(",");
        } catch (Exception e) {
            // TODO 에러사항 세분화 하기 : 자동차 이름의 length 5자 이하만 가능, 중복 제거
            System.err.println("[ERROR] 잘못된 입력값입니다.");
            throw new IllegalArgumentException();
        }

        return carNames;
    }
}
