/**
 * OutputView.java
 * 입력을 제외한 출력을 담당하는 View 클래스
 *
 * @author Kimun Kim / kkm97351@gmail.com
 */

package racingcar.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void showErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
