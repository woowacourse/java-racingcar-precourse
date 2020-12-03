package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("이름과 함께 도메인이 잘 생성 되는 지 확인")
    public void createCarDomain() throws Exception{
        //given
        final String NAME = "bomin";
        //when
        Car car = new Car(NAME);
        //then
        assertEquals(NAME, car.getName());
    }
    
    @Test
    public void runWithRunnableNumber() throws Exception{
        //given
        final int RUN_NUM = 4;
        final int EXPECTED_POSITION = 1;
        //when
        Car car = createCar();
        car.run(RUN_NUM);
        //then
        assertEquals(EXPECTED_POSITION, car.getCurrentPosition());
    }
    
    @Test
    public void runWithUnrunnableNumber() throws Exception{
        //given
        final int RUN_NUM = 3;
        final int EXPECTED_POSITION = 0;
        //when
        Car car = createCar();
        car.run(RUN_NUM);
        //then
        assertEquals(EXPECTED_POSITION, car.getCurrentPosition());
    }

    private Car createCar(){
        return new Car("bomin");
    }

}