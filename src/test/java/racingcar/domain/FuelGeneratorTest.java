package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FuelGeneratorTest {

    @Test
    @DisplayName("입력값만큼 연료를 생성하는지 테스트")
    public void generate_FixedFuel_returnInputFuel() {

        // given
        FuelGenerator fuelGenerator = new FixedFuelGenerator(4);

        // when
        int fuel = fuelGenerator.generate();

        // then
        assertThat(fuel).isEqualTo(4);
    }
}
