package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car.Cars;
import racingcar.Car.CarsFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {
    static Racing racing;
    static Cars cars;

    @BeforeAll
    static void setUp() {
        cars = CarsFactory.createCars(new String[]{"A", "B"});
    }

    @DisplayName("round가 잔존 여부에 따라 hasNextRound()가 True 혹은 False 반환한다.")
    @Test
    void 라운드가_남아있는지_확인() {
        racing = new Racing(cars, 1);
        assertThat(racing.hasNextRound()).isTrue();

        racing.nextRound();
        assertThat(racing.hasNextRound()).isFalse();
    }

    @DisplayName("남은 라운드가 없을 때 next()를 호출하면 에러가 발생한다")
    @Test
    void 라운드가_없을_때() {
        racing = new Racing(cars, 0);
        assertThatThrownBy(() -> racing.nextRound()).isInstanceOf(IllegalStateException.class);
    }


    @DisplayName("최종 우승자가 여럿일 경우 함께 출력한다")
    @Test
    void 우승자가_여럿이면_함께_출력() {
        racing = new Racing(cars, 0);
        assertThat(racing.printResult()).isEqualTo("최종 우승자 : A, B");
    }
}