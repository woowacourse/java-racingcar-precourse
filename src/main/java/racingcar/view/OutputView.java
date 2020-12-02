package racingcar.view;

public class OutputView {
    private OutputView() {

    }

    public static void getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printErrorMessageAboutName() {
        System.out.println("[ERROR] 자동차의 이름은 1자 이상, 5자 이하의 중복되지 않는 이름만 가능합니다.\n");
    }

    public static void getTrials() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printErrorMessageAboutTrial() {
        System.out.println("[ERROR] 횟수는 1 이상의 숫자만 입력 가능합니다.\n");
    }

    public static void showResultHeader(){
        System.out.println("실행 결과");
    }
}
