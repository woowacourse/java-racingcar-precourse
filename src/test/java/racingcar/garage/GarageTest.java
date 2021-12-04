package racingcar.garage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GarageTest {
    private Set<Car> carSet;
    private Car pobi;
    private Car woni;
    private Car jun;

    @BeforeEach
    void init() {
        pobi = Car.from("pobi");
        woni = Car.from("woni");
        jun = Car.from("jun");
    }

    @Test
    @DisplayName(value = "차 여러대 저장")
    void Car_여러대_저장() {
        Garage garage = Garage.from(Arrays.asList(pobi, woni, jun));

        assertThat(garage.containsCar(pobi)).isTrue();
        assertThat(garage.containsCar(woni)).isTrue();
        assertThat(garage.containsCar(jun)).isTrue();

        assertThat(garage.containsCar(Car.from("woowa"))).isFalse();
    }

}
