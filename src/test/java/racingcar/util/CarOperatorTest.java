package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarOperatorTest {
    @Test
    @DisplayName("CarOperator가 반환하는 현재 턴의 랜덤값 사이즈 확인")
    public void carOperatorSizeTest(){
        CarOperator carOperator = new CarOperator(new RandomNumberGenerate(), 3);
        Assertions.assertEquals(carOperator.tempPosition().size(), 3);
    }

}