package racingcar;

import java.util.ArrayList;

public interface IRacingGamePrinter {
    /** 이름을 입력하라고 안내 */
    void inputNames();

    /** 입력한 이름이 부적합하다고 안내 */
    void errorInputPlayer();

    /** 시도 횟수를 입력하라고 안내 */
    void inputReps();

    /** 입력한 시도 횟수가 부적합하다고 안내 */
    void errorInputReps();

    /** 경주 시작을 안내 */
    void start();

    /**
     * 경주 상황이 담긴 값을 반환
     * @param cars 모든 차량
     */
    void status(ArrayList<Car> cars);

    /**
     * 우승자 명단을 반환
     * @param cars 모든 우승한 차량
     */
    void winner(ArrayList<Car> cars);
}
