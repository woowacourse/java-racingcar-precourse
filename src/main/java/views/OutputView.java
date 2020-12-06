package views;

import domain.Car;
import domain.RaceWinner;
import domain.RacingCars;

public class OutputView {
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";
    private static final String FINAL_WINNER = "최종 우승자: ";
    private static final String NAME_SEPARATOR = ", ";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 2;

    public static void printOneRound(RacingCars racingCars) {
        for (Car car : racingCars.getCarList()) {
            System.out.print(car.getName() + COLON);
            drawPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void drawPosition(Car car) { // 메소드 분리필요
        int position = car.getPosition();
        StringBuilder moveDistance = new StringBuilder();
        for (int i = 1; i <= position; i++) {
            moveDistance.append(HYPHEN);
        }
        System.out.println(moveDistance.toString());
    }

    public static void printWinner(RaceWinner raceWinner) {
        System.out.print(FINAL_WINNER);
        System.out.println(makeWinnerString(raceWinner));
    }

    private static String makeWinnerString(RaceWinner raceWinner) {
        StringBuilder winnerString = new StringBuilder();
        for (Car car : raceWinner.getRaceWinners()) {
            winnerString.append(car.getName());
            winnerString.append(NAME_SEPARATOR);
        }
        return winnerString.substring(START_INDEX, winnerString.length() - END_INDEX);
    }
}
