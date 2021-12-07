package racingcar.view;

public class ResultView {
    private static final String WINNER_MESSAGE_INTRO = "최종 우승자 : ";

    public static void printWinner(String winners) {
        System.out.println(WINNER_MESSAGE_INTRO + winners);
    }
}
