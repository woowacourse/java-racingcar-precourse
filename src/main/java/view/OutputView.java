package view;

import model.Car;
import util.StringUtil;

import java.util.List;

public class OutputView {
    private static final String MSG_RESULT_TITLE = "실행결과";
    private static final String MSG_WINNER = "가 최종 우승했습니다.";

    public void printTitle() {
        System.out.println(MSG_RESULT_TITLE);
    }

    public void printCurrentRound(List<Car> participants) {
        participants.forEach(p -> System.out.println(p.toString()));
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerStr = StringUtil.getNameJoinResult(winners);
        System.out.println(winnerStr + MSG_WINNER);
    }
}
