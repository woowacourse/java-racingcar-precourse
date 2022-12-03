package racingcar;

public class OutputView {
    public void printError(String message) {
        System.out.println(message);
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
