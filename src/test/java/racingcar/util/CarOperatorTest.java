package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarOperatorTest {
    @Test
    public void carOperatorSizeTest() throws Exception{
        CarOperator carOperator = new CarOperator(new RandomNumberGenerate(), 3);
        Assertions.assertEquals(carOperator.tempPosition().size(), 3);
    }

}