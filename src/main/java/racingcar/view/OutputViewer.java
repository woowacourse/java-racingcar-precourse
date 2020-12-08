package racingcar.view;

import racingcar.domain.Car;

public class OutputViewer {
    private static final int START_POINT = 0;
    private static final String COLON_MESSAGE = " : ";
    private static final String EXPRESS_PROGRESS_MESSAGE = "-";
    private static final String FIRST_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자: ";

    /* 결과 표시 시작을 알리는 메시지 */
    public static void initiateResult() {
        System.out.println();
        System.out.printf("%s \n", FIRST_RESULT_MESSAGE);
    }

    /**
     * 참여자들의 스코어를 보여주는 메소드
     * @param car 결과를 보여줄 참여 자동차
     */
    public static void showScoreName(Car car) {
        String participantName = car.getName();
        int position = car.getPosition();
        System.out.printf("%s", participantName);
        System.out.print(COLON_MESSAGE);
        showParticipantScore(position);
    }

    private static void showParticipantScore(int position) {
        for (int i = START_POINT; i < position; i++) {
            System.out.print(EXPRESS_PROGRESS_MESSAGE);
        }
        System.out.println();
    }

    /**
     * 우승자 결과를 보여주는 메서드
     * @param finalWinnerName 우승자 명단
     */
    public static void showFinalWinner(String finalWinnerName) {
        System.out.print(FINAL_WINNER_MESSAGE);
        System.out.printf("%s", finalWinnerName);
    }

    /* 게임간 간격 확보영 메서드 */
    public static void insertSpaceBetweenGames() {
        System.out.println();
    }
}
