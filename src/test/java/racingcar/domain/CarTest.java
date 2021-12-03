package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("현재 position이 0인 자동차가 한 칸 이동할 경우, 다음 위치 확인에 관한 테스트")
    @Test
    void carPositionTest() {
        Car car = new Car("jay");
        car.move(() -> true);
        Assertions.assertThat(car.position()).isEqualTo(1);
    }
}