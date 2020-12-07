/**
 * OutputView.java
 * 입력을 제외한 출력을 담당하는 View 클래스
 *
 * @author Kimun Kim / kkm97351@gmail.com
 */

package racingcar.view;

import racingcar.domain.CarDTO;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String DISPLAY_POSITION_FORMAT = "%s : %s";
    private static final char POSITION_CHARACTER = '-';

    public static void showErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void showCarsPosition(List<CarDTO> carsDTO) {
        carsDTO.forEach(OutputView::showCarPosition);
        System.out.println();
    }

    private static void showCarPosition(CarDTO carDTO) {
        StringBuffer positionStringBuffer = new StringBuffer();
        IntStream.range(0, carDTO.getPosition())
                .forEach(i -> positionStringBuffer.append(POSITION_CHARACTER));
        System.out.print(String.format(DISPLAY_POSITION_FORMAT, carDTO.getName(), positionStringBuffer));
        System.out.println();   // 개행
    }
}
