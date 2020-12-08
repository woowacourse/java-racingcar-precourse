package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    @Test
    @DisplayName("객체 생성 테스트")
    void 객체_생성_테스트() {
        RacingCars racingCars = new RacingCars("one,two,three");

        String[] cars = {"one", "two", "three"};

        int i = 0;
        for (Car car : racingCars.getCarList()) {
            Assertions.assertEquals(cars[i++], car.getName());
        }
    }

    @Test
    @DisplayName("자동차가 한대만 들어온 경우")
    void 한_대의_자동차_예외_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String singleCar = "poooo";
            new RacingCars(singleCar);
        });
        Assertions.assertEquals("[ERROR] 한대의 차량으로는 경주할 수 없습니다.", exception.getMessage());
    }
}