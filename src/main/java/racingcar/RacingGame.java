package racingcar;

public class RacingGame {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final int FIRST_ROUND = 1;
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자: ";

    private void showLeaderBoard(Cars cars) {
        cars.getCarPositionAnnouncement();
        System.out.println();
    }

    private void announceWinners(Cars cars) {
        System.out.println(WINNER_ANNOUNCEMENT + cars.getWinners());
    }

    public void startRacing(Cars cars, int numberOfRounds) {
        System.out.println(GAME_RESULT_MESSAGE);
        for (int round = FIRST_ROUND; round <= numberOfRounds; round ++) {
            cars.moveCars();
            showLeaderBoard(cars);
        }
        announceWinners(cars);
    }
}
