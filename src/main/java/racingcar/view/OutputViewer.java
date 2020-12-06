package racingcar.view;

import java.util.ArrayList;

public class OutputViewer {
    private static final String FIRST_RESULT_MESSAGE = "실행 결과";
    private static final String PARTICIPANT_NAME_MESSAGE = "%s";
    private static final String EXPRESS_PROGRESS_MESSAGE = "-";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자: ";

    /* 결과 표시 시작을 알리는 메시지 */
    public static void initiateResult() {
        System.out.println(" ");
        System.out.printf("%s \n", FIRST_RESULT_MESSAGE);
    }

    /**
     * 참여자들의 스코어를 보여주는 메서드
     * @param participantName 참여자의 이름
     * @param score 참여자의 스코어
     */
    public static void participantScoreName(String participantName, int score) {
        System.out.printf(PARTICIPANT_NAME_MESSAGE, participantName);
        System.out.print(" : ");
        participantScore(score);
    }

    private static void participantScore(int score) {
        for(int i = 0 ; i < score ; i++){
            System.out.print(EXPRESS_PROGRESS_MESSAGE);
        }
        System.out.println(" ");
    }

    /**
     * 우승자가 하나일 경우에, 결과를 보여주는 메서드
     * @param finalSoloWinnerName 솔로 우승자
     */
    public static void finalWinner(String finalSoloWinnerName) {
        System.out.print(FINAL_WINNER_MESSAGE);
        System.out.printf("%s", finalSoloWinnerName);
    }

    /* 게임간 간격 확보영 메서드 */
    public static void spaceBetweenGames() {
        System.out.println(" ");
    }
}
