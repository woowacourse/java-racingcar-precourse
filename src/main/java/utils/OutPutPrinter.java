package utils;

import racingcar.Car;
import racingcar.CarList;

public class OutPutPrinter {
    private static final String FINAL_WINNER = "최종 우승자: ";
    private static final String NEW_LINE = "\n";

    public static void carRacingResultPrint(CarList carList) {
        StringBuilder result = new StringBuilder();

        for (Car car : carList.getCarList()) {
            result.append(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                result.append("-");
            }
            result.append(NEW_LINE);
        }
        System.out.println(result.toString());
    }

    public static void carRaceWinnerPrint(String winners) {
        System.out.println(FINAL_WINNER + winners);
    }
}
