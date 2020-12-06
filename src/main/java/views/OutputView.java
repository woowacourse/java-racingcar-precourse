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
            System.out.print(car.getName().getName() + COLON); // 메소드명 수정 필요
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
            winnerString += car.getName().getName(); // 메소드명 수정 필요
            winnerString += NAME_SEPARATOR;
        }
        return winnerString.substring(START_INDEX, winnerString.length() - END_INDEX);
    }
}
