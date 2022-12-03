package racingcar;

public class OutputView {
    public void printError(String message) {
        print(message);
    }

    public void printWinners(String winners) {
        print("최종 우승자 : " + winners);
    }

    public void printGameStart() {
        print("실행 결과");
    }

    public void printProgress(String progress) {
        print(progress);
    }

    private void print(String message) {
        System.out.println(message);
    }
}
