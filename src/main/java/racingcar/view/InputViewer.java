package racingcar.view;

public class InputViewer {
    private static final String carsInputMessage = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String numberInputMessage = "시도할 회수는 몇회인가요?";
    private static final String carsInputErrorMesage = "[ERROR] 중복된 차 이름이 있으면 안된다.";
    private static final String numberInputErrorMessage = "[ERROR] 시도 횟수는 숫자여야 한다.";

    /* 초기 차들의 이름을 받는 메세지 */
    public static void carsInput() {
        System.out.println(carsInputMessage);
    }

    /* 경주 횟수를 묻는 메세지 */
    public static void numberInput() {
        System.out.println(numberInputMessage);
    }

    /* 중복된 차 감지시에 에러 메세지 */
    public static void carsInputError() {
        throw new IllegalArgumentException(carsInputErrorMesage);
    }

    /* 시도 횟수가 정수가 아닐 시에 메세지 */
    public static void numberInputError(){
        throw new IllegalArgumentException(numberInputMessage);
    }
}
