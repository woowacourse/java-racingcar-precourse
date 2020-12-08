package utils;

import java.util.Scanner;

/**
 * 프로그램의 입력 부분을 담당하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/05
 */
public class InputUtils {

    private final Scanner scanner;
    private final ValidationUtils validationUtils;
    private final PrintUtils printUtils;

    public InputUtils() {
        scanner = new Scanner(System.in);
        validationUtils = new ValidationUtils();
        printUtils = new PrintUtils();
    }

    /* 자동차들의 이름을 입력받아 쉼표로 구분하여(,) 반환하는 메소드 */
    public String[] inputCarsName() {
        try {
            String namesInput = scanner.nextLine();
            String[] nameList = namesInput.split(",");
            if (validationUtils.isValidNames(nameList) == false) {
                throw new IllegalArgumentException();
            }
            return nameList;
        } catch (IllegalArgumentException e) {
            printUtils.printNameErrorMessage();
            return inputCarsName();
        }
    }

    /* 시도할 게임 회수를 입력하는 메소드 */
    public int inputNumberOfGame() {
        try {
            int gameNumber = Integer.parseInt(scanner.nextLine());
            if (validationUtils.isValidNumberOfGame(gameNumber) == false) {
                throw new IllegalArgumentException();
            }
            return gameNumber;
        } catch (IllegalArgumentException e) {
            printUtils.printNumberErrorMessage();
            return inputNumberOfGame();
        }
    }
}
