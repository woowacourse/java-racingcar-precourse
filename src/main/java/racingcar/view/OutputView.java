package racingcar.view;

public class OutputView {
    private static final String CAR_NAME_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_TRY_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
    
    public void printCarNameInputGuideMessage() {
        println(CAR_NAME_INPUT_GUIDE_MESSAGE);
    }
    
    public void printNumberOfTryInputGuideMessage() {
        println(NUMBER_OF_TRY_INPUT_GUIDE_MESSAGE);
    }
    
    private void println(final String message) {
        System.out.println(message);
    }
    
    public void printErrorMessage(final IllegalArgumentException raisedException) {
        System.out.println(raisedException.getMessage());
    }
}
