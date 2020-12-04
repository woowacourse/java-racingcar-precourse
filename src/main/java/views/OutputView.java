package views;

import domain.Car;
import domain.RaceWinner;
import domain.RacingCars;

public class OutputView {
    private final static String COLON = " : ";
    private final static String HYPHEN = "-";
    private final static String FINAL_WINNER = "최종 우승자: ";
    private final static String NAME_SEPARATOR = ", ";
    private final static int START_INDEX = 0;
    private final static int END_INDEX = 2;

    public static void printOneRound(RacingCars racingCars) {
        for (Car car : racingCars.getCarList()) {
            System.out.print(car.getName() + COLON);
            drawPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void drawPosition(Car car) {
        int position = car.getPosition();
        for (int i = 1; i <= position; i++) {
            System.out.print(HYPHEN);
        }
    }

    public static void printWinner(RaceWinner raceWinner) {
        System.out.print(FINAL_WINNER);
        System.out.println(makeWinnerString(raceWinner));
    }

    private static String makeWinnerString(RaceWinner raceWinner) {
        String winnerString = new String();
        for (Car car : raceWinner.getRaceWinners()) {
            winnerString += car.getName();
            winnerString += NAME_SEPARATOR;
        }
        return winnerString.substring(START_INDEX, winnerString.length() - END_INDEX);
    }
}
