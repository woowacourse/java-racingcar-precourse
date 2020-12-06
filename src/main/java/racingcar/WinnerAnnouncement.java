package racingcar;

import java.util.ArrayList;

public class WinnerAnnouncement {
    private static ArrayList<String> winners = new ArrayList<String>();

    private static final String WINNER_ANNOUNCEMENT = "최종 우승자: ";

    public static void checkWinner(int finalFrontRunnerPosition, ArrayList<Car> carsInGame) {
        for (Car car : carsInGame) {
            if (car.getPosition() == finalFrontRunnerPosition) {
                winners.add(car.getName());
            }
        }
    }

    public static void announce() {
        System.out.print(WINNER_ANNOUNCEMENT);
        StringBuilder announcement = new StringBuilder();
        for (String winner : winners) {
            if (announcement.length() > 0) {
                announcement.append(", ");
            }
            announcement.append(winner);
        }
        System.out.println(announcement.toString());
    }
}
