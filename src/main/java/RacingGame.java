import java.util.Scanner;

public class RacingGame {
    private static final String MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String CAR_NAME_DELIMETER = ",";
    private static final String MESSAGE_NAME_LIMIT = "자동차 이름은 5글자 이하만 가능합니다.";
    private static Scanner scanner;


    private RacingGame() {
        scanner = new Scanner(System.in);    //어디 둘지, 곤란
        String[] carNames = nameCars();
    }

    public static void main(String[] args) {
        new RacingGame();
    }

    private String[] nameCars() {
        String[] splitedCarNames;

        do {
            System.out.println(MESSAGE_INPUT_CAR_NAMES);
            String carNames = scanner.nextLine();
            splitedCarNames = carNames.split(CAR_NAME_DELIMETER);
        } while (!validateCarNames(splitedCarNames));

        return splitedCarNames;
    }

    private boolean validateCarName(String carName) {
        return carName.length() <= 5;
    }

    private boolean validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (!validateCarName(carName)) {
                System.out.println(MESSAGE_NAME_LIMIT);
                return false;
            }
        }
        return true;
    }
}
