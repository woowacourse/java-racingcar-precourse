package racingcar.garage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GarageTest {
    private final String ROUND_REAULT = "pobi : --\nwoni : \njun : -\n";

    private Car pobi;
    private Car woni;
    private Car jun;
    private Garage garage;

    @BeforeEach
    void init() {
        pobi = Car.from("pobi");
        woni = Car.from("woni");
        jun = Car.from("jun");
        garage = Garage.from(Arrays.asList(pobi, woni, jun));
    }

    @Test
    @DisplayName(value = "차 여러대 저장")
    void Car_여러대_저장() {
        assertThat(garage.containsCar(pobi)).isTrue();
        assertThat(garage.containsCar(woni)).isTrue();
        assertThat(garage.containsCar(jun)).isTrue();

        assertThat(garage.containsCar(Car.from("woowa"))).isFalse();
    }

    @Test
    void Car_별로_라운드_결과() {
        moving();
        assertThat(garage.whereAreCars()).isEqualTo(ROUND_REAULT);
    }

    @Test
    void 우승자_찾기_pobi() {
        moving();
        assertThat(garage.whichWin()).isEqualTo("pobi");
    }

    private void moving() {
        pobi.move();
        pobi.move();
        jun.move();
    }
}
