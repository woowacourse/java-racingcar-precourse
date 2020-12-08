import controller.RacingCarGameController;
import view.InputView;

import java.util.Scanner;

/**
 * 프로그램을 시작하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 3일
 */
public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        final InputView inputView = new InputView(scanner);
        final RacingCarGameController racingCarGameController = new RacingCarGameController(inputView);

        racingCarGameController.run();
    }
}
