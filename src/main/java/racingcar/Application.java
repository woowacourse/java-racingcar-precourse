package racingcar;

import java.util.Scanner;

/**
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 * 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
 * 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
 * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
 */


/**
 * 기능구현
 * 1. 자동차 이름을 입력받는 기능 (inputCarInfo)
 *   가. 이름을 입력받을 때 쉼표 사이가 붙어있다면 이름이 없으므로 에러 (checkCarNameEmpty)
 *   나. 이름을 입력받을 때 이름의 길이가 5글자가 넘는다면 에러 (checkCarNameGreaterThenFive)
 *
 * 2. 자동차 이동 시도 횟수를 입력받는 기능 (inputCarMoveAttemptCount)
 *   가. 자동차 이동 시도 횟수가 숫자가 아니라면 에러 (checkCarMoveAttemptCount)
 *
 *
 * 3. 경주 게임 interface 구현
 *   가. 경주 게임을 시작하는 기능 (startRacingGame) - public
 *   나. 입력받은 이동 시도 횟수만큼 움직이거나 가만히 있는 기능 (carMoveOrStay) - private
 *   다. 자동차가 전진하는 기능 (increasePosition)
 *   라. 경주 완료 후 우승자 선별 기능 (findWinner)
 *   마. 우승자 출력 기능 (printWinner)
 *
 * 4. 자동차 경주 게임 class 구현
 *
 */
public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }
}
