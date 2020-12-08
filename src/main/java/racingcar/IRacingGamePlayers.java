package racingcar;

import java.util.ArrayList;

public interface IRacingGamePlayers {
    /**
     * 입력값으로 Car 생성을 시도하고 성공여부를 반환
     * @param names Car 생성에 필요한 이름들
     * @return 성공여부
     */
    boolean trySetCars(String names);

    /**
     * 모든 차량들을 반환
     * @return 모든 차량들
     */
    ArrayList<Car> getCars();

    /**
     * 모든 우승 차량들을 반환
     * @return 모든 우승 차량들
     */
    ArrayList<Car> getWinner();
}
