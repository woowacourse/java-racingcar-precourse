package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.CarNameDuplicationException;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {

    @DisplayName("Cars 객체 생성 성공 : 이름들에 중복이 없는 경우")
    @Test
    public void createCars_중복없는_이름들_객체_생성_성공() {
        List<String> carNames = Arrays.asList("pobi", "crong", "jiko", "ajax");

        assertThatCode(() -> {
            Cars.createCars(carNames, new RandomMovingStrategy());
        }).doesNotThrowAnyException();
    }

    @DisplayName("Cars 객체 생성 실패 : 이름들에 중복이 존재하는 경우")
    @Test
    public void createCars_중복있는_이름들_예외_발생() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "jiko", "ajax");

        assertThatCode(() -> {
            Cars.createCars(carNames, new RandomMovingStrategy());
        }).isInstanceOf(CarNameDuplicationException.class);
    }

    @DisplayName("Car 객체들의 이름 리스트를 반환한다.")
    @Test
    public void getCarNames_이름들이_반환된다() {
        List<String> carNames = Arrays.asList("pobi", "crong", "jiko", "ajax");
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());

        assertThat(cars.getCarNames()).hasSameElementsAs(carNames);
    }

    @DisplayName("Car 객체들의 Position 리스트를 반환한다.")
    @Test
    public void getCarPositions_위치가_반환된다() {
        List<String> carNames = Arrays.asList("pobi", "crong", "jiko", "ajax");
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());

        assertThat(cars.getCarPositions()).hasSameElementsAs(Arrays.asList(0, 0, 0, 0));
    }

    @DisplayName("항상 움직이지 않는 전략의 경우, Cars 객체에 move를 요청하면 차량들의 위치가 변하지 않는다.")
    @Test
    public void move_항상_움직이지_않는_전략_position이_변함없다() {
        List<String> carNames = Arrays.asList("pobi", "crong", "jiko", "ajax");
        MovingStrategy neverMovingStrategy = () -> false;
        Cars cars = Cars.createCars(carNames, neverMovingStrategy);

        cars.move();

        assertThat(cars.getCarPositions()).hasSameElementsAs(Arrays.asList(0, 0, 0, 0));
    }

    @DisplayName("항상 움직이는 전략의 경우, Cars 객체에 move를 요청하면 차량들의 위치가 1 증가한다.")
    @Test
    public void move_항상_움직이는_전략_position이_1만큼_증가한다() {
        List<String> carNames = Arrays.asList("pobi", "crong", "jiko", "ajax");
        MovingStrategy alwaysMovingStrategy = () -> true;
        Cars cars = Cars.createCars(carNames, alwaysMovingStrategy);

        cars.move();

        assertThat(cars.getCarPositions()).hasSameElementsAs(Arrays.asList(1, 1, 1, 1));
    }
}
