package racingcar;

public class GameDisplay {

    public static final String EXECUTION_RESULT = "실행결과";

    public void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputRoundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printEachRoundResult(Car car) {
        System.out.println(car.getCarName() + " : " + car.getSpeed());
    }

}
