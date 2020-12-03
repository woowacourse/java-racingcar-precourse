package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.generator.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class EngineTest {
    @Mock
    private RandomNumberGenerator randomNumberGenerator;

    @InjectMocks
    private Engine engine;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        engine = new Engine(randomNumberGenerator);
    }

    @Test
    public void testEngineReturningZero(){
        //given
        //when
        when(randomNumberGenerator.generateRandomNumber()).equals(1);
        //than
        assertThat(engine.run()).isEqualTo(0);
    }

    @Test
    public void testEngineReturningOne(){
        //given
        //when
        when(randomNumberGenerator.generateRandomNumber()).equals(5);
        //then
        assertThat(engine.run()).isEqualTo(1);
    }
}