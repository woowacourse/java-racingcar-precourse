package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class CarTest {
    @Mock
    private Engine mockEngine;

    private Car car;

    @BeforeEach
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.openMocks(this);
        car = new Car("bee");
        Field engine = car.getClass().getDeclaredField("engine");
        engine.setAccessible(true);
        engine.set(car, mockEngine);
    }

    @Test
    public void carMoveTestOne() {
        //given
        //when
        when(mockEngine.run()).thenReturn(1);
        car.move();
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void carMoveTestZero() {
        //given
        //when
        when(mockEngine.run()).thenReturn(0);
        car.move();
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void toStringTest(){
        //given
        //when
        when(mockEngine.run()).thenReturn(1);
        car.move();
        //then
        assertThat(car.toString()).isEqualTo("bee : -");
        //when
        when(mockEngine.run()).thenReturn(1);
        car.move();
        //then
        assertThat(car.toString()).isEqualTo("bee : --");
    }
}