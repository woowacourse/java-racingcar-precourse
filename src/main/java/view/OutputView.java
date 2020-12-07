package view;

import racingcar.Car;

import java.util.Arrays;

public class OutputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String CAR_NAME_COUNT_ERROR_MESSAGE = "[ERROR] 경주할 자동차는 한 대 이상이어야 합니다.";
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 경주할 자동차의 이름 길이는 1 이상 5 이하여야 합니다.";
    private static final String CAR_NAME_DUPLICATION_ERROR_MESSAGE = "[ERROR] 경주할 자동차의 이름이 중복됩니다.";
    private static final String TRY_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    private static final String TRY_NUMBER_NEGATIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수여야 합니다.";
    private static final String GAME_RESULT = "실행 결과";
    private static final String COMMA_SPACE = ", ";

    private OutputView() {
    }

    public static void showWinner(Car[] racingCars) {
        Arrays.sort(racingCars);
        System.out.print("최종 우승자: " + racingCars[0].getName());
        for (int i = 1; i < racingCars.length - 1; i++) {
            if (racingCars[0].compareTo(racingCars[i]) == 0) {
                System.out.print(COMMA_SPACE + racingCars[i].getName());
            }
        }
    }

    public static void showOneRoundResult(Car racingCar) {
        String racingCarName = racingCar.getName();
        int racingCarPosition = racingCar.getPosition();

        System.out.print(racingCarName + " : ");
        for (int i = 0; i < racingCarPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void showCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public static void showTryNumberMessage() {
        System.out.println(TRY_NUMBER_MESSAGE);
    }

    public static void showTryNumberTypeErrorMessage() {
        System.out.println(TRY_NUMBER_TYPE_ERROR_MESSAGE);
    }

    public static void showAllRoundResultMessage() {
        System.out.println();
        System.out.println(GAME_RESULT);
    }

    public static String getNegativeErrorMessage() {
        return TRY_NUMBER_NEGATIVE_ERROR_MESSAGE;
    }

    public static String getCarNameCountErrorMessage() {
        return CAR_NAME_COUNT_ERROR_MESSAGE;
    }

    public static String getCarNameLengthErrorMessage() {
        return CAR_NAME_LENGTH_ERROR_MESSAGE;
    }

    public static String getCarNameDuplicationErrorMessage() {
        return CAR_NAME_DUPLICATION_ERROR_MESSAGE;
    }
}
