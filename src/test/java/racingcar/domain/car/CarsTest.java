package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.CarDto;
import racingcar.domain.exception.CarNameException;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {

    private final List<String> carNames = Arrays.asList("pobi", "crong", "jiko", "ajax");

    @DisplayName("Cars 객체 생성 성공 : 이름들에 중복이 없는 경우")
    @Test
    void createCars_중복없는_이름들_객체_생성_성공() {
        assertThatCode(() -> {
            Cars.createCars(carNames, new RandomMovingStrategy());
        }).doesNotThrowAnyException();
    }

    @DisplayName("Cars 객체 생성 실패 : 이름들에 중복이 존재하는 경우")
    @Test
    void createCars_중복있는_이름들_예외_발생() {
        List<String> duplicatedCarNames = Arrays.asList("pobi", "pobi", "jiko", "ajax");

        assertThatCode(() -> {
            Cars.createCars(duplicatedCarNames, new RandomMovingStrategy());
        }).isInstanceOf(CarNameException.class)
                .hasMessage("[ERROR] 자동차 이름들 중 중복이 존재해서는 안됩니다.");
    }

    @DisplayName("Car 객체들의 DTO 리스트를 반환")
    @Test
    void getCarDtos_name_리스트를_확인한다() {
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());

        List<String> targetCarNames = cars.getCarDtos().stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());

        assertThat(targetCarNames).hasSameElementsAs(carNames);
    }

    @DisplayName("Car 객체들의 DTO 리스트를 반환")
    @Test
    void getCarDtos_position_리스트를_확인한다() {
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());

        List<Integer> carPositions = cars.getCarDtos().stream()
                .map(CarDto::getPosition)
                .collect(Collectors.toList());

        assertThat(carPositions).hasSameElementsAs(Arrays.asList(0, 0, 0, 0));
    }

    @DisplayName("Cars 객체에서 move가 실패하면 position은 변함 없음")
    @Test
    void move_실패시_position이_변함없다() {
        MovingStrategy neverMovingStrategy = () -> false;
        Cars cars = Cars.createCars(carNames, neverMovingStrategy);
        cars.move();

        List<Integer> carPositions = cars.getCarDtos().stream()
                .map(CarDto::getPosition)
                .collect(Collectors.toList());

        assertThat(carPositions).hasSameElementsAs(Arrays.asList(0, 0, 0, 0));
    }

    @DisplayName("Cars 객체에서 move가 성공하면 position은 1만큼 증가함")
    @Test
    void move_성공시_position이_1만큼_증가한다() {
        MovingStrategy alwaysMovingStrategy = () -> true;
        Cars cars = Cars.createCars(carNames, alwaysMovingStrategy);
        cars.move();

        List<Integer> carPositions = cars.getCarDtos().stream()
                .map(CarDto::getPosition)
                .collect(Collectors.toList());

        assertThat(carPositions).hasSameElementsAs(Arrays.asList(1, 1, 1, 1));
    }

    @DisplayName("가장 멀리 이동한 우승 자동차들의 명단을 반환함")
    @Test
    void getWinnerCarNames_우승_자동차_이름_명단을_반환한다() {
        MovingStrategy alwaysMovingStrategy = () -> true;
        Cars cars = Cars.createCars(carNames, alwaysMovingStrategy);

        List<String> winnerCarNames = cars.getWinnerCarNames();

        assertThat(winnerCarNames).hasSameElementsAs(carNames);
    }
}
