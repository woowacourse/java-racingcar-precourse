package view;

public class InputView implements InputDisplayable {
    private static final String ERROR_SYMBOL = "[ERROR] ";

    @Override
    public void alertInputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void alertInputCountOfAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void printErrorMessage(final String message) {
        System.out.println(ERROR_SYMBOL + message);
    }
}
