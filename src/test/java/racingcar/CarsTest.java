package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    public void testCreate() {
        Cars cars = Cars.makeCars("pobi,jun,joy");
        
        assertThat(cars).isNotNull();
    }

}
