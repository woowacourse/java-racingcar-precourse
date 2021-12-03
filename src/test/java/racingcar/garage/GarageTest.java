package racingcar.garage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GarageTest {
    private Set<Car> carSet;
    private Car pobi;
    private Car woni;
    private Car jun;

    @BeforeEach
    void init() {
        carSet = new HashSet<>();
        pobi = Car.from("pobi");
        woni = Car.from("woni");
        jun = Car.from("jun");
    }

    @Test
    @DisplayName(value = "차 여러대 저장")
    void Car_여러대_저장() {
        carSet.addAll(Arrays.asList(pobi, woni, jun));
        Garage garage = Garage.from(carSet);

        assertThat(garage.hasCar(pobi)).isTrue();
        assertThat(garage.hasCar(woni)).isTrue();
        assertThat(garage.hasCar(jun)).isTrue();

        Car woowa = Car.from("woowa");
        assertThat(garage.hasCar(woowa)).isFalse();
    }

}
