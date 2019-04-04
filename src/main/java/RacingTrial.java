import domain.Car;

import java.util.List;

public class RacingTrial {
    // Racing 의 내용을 담은 객체

    // 각 trial 에서 무슨일을 해야하는지가 명시되어 있음
    // 테스트에서 각 trial 에서 어떤 순서로 어떤 작업이 일어나야하는지를 검증하기 위해서 이런 식으로 역할을 나눴음
    void doTrial(List<Car> cars, ScoreBoard board) {
        cars.forEach((car) -> car.tryMove());

        board.Print(cars);
    }


}
