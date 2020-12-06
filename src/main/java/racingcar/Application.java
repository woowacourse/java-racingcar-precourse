/**
 * Application.java
 * 자동차 경주 게임 어플리케이션
 *
 * @author
 * 원작자: 우아한 테크코스(github.com/woowacourse)
 * 수정: Kimun Kim, github.com/tributetothemoon
 */

package racingcar;

import java.util.Scanner;
import racingcar.controller.RaicingCarGame;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        InputView.setScanner(scanner);

        Cars cars = getCarNamesFromUser();
        RaicingCarGame raicingCarGame = new RaicingCarGame(cars);
        raicingCarGame.play();
    }

    private static Cars getCarNamesFromUser() {
        try{
            return Cars.of(InputView.getCarNames());
        }catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            return getCarNamesFromUser();
        }
    }
}
