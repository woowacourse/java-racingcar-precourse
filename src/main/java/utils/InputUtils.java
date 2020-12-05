package utils;

import java.util.Scanner;

public class InputUtils {
    private final Scanner scanner;
    private final ValidationUtils validationUtils;

    public InputUtils(){
        scanner = new Scanner(System.in);
        validationUtils = new ValidationUtils();
    }

    /* 자동차들의 이름을 입력받아 쉼표로 구분하여(,) 반환하는 메소드 */
    public String[] inputCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String namesInput = scanner.nextLine();
            String[] nameList = namesInput.split(",");
            if (validationUtils.isValidNames(nameList) == false) {
                throw new IllegalArgumentException();
            }
            return nameList;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이름은 5자리 이하 문자를 입력해주세요.");
            return inputCarsName();
        }
    }

    /* 시도할 게임 회수를 입력하는 메소드 */
    public int inputNumberOfGame() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int gameNumber = Integer.parseInt(scanner.nextLine());
            if (validationUtils.isValidNumberOfGame(gameNumber)==false) {
                throw new IllegalArgumentException();
            }
            return gameNumber;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 양의 정수를 입력해주세요.");
            return inputNumberOfGame();
        }
    }
}
