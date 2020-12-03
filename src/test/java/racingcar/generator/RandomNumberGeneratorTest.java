package racingcar.generator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    @Test
    void randomNumberGeneratorTest(){
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        //when
        //then
        assertThat(randomNumberGenerator.generateRandomNumber()).isBetween(1, 9);
    }
}