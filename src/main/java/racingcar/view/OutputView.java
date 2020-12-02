package racingcar.view;

public class OutputView {
    private OutputView() {

    }

    public static void getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printErrorMessageAboutLengthOfName() {
        System.out.println("[ERROR] 자동차의 이름은 1자 이상, 5자 이하만 가능합니다.\n");
    }
}
