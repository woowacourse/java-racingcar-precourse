package domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCarsTest {

    @DisplayName("우승자 이름들 가져오기")
    @Test
    void getWinnersName() {
        WinningCars winningCars = new WinningCars(Arrays.asList(new Car("pci"), new Car("chan")));

        assertThat(winningCars.getWinnersName()).contains("pci", "chan");
    }
}