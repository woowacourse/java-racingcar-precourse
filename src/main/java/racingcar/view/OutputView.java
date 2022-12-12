package racingcar.view;

public class OutputView {

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
