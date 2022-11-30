package racingcar.view;

public class OutputView {
    
    public static final String CAR_NAME_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    
    public void printCarNameInputGuideMessage() {
        println(CAR_NAME_INPUT_GUIDE_MESSAGE);
    }
    
    private void println(final String message) {
        System.out.println(message);
    }
    
    public void printErrorMessage(final IllegalArgumentException raisedException) {
        System.out.println(raisedException.getMessage());
    }
}
