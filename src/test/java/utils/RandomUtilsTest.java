package utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomUtilsTest {

    @Test
    public void Should_Make_More_than_1_Under_10_When_Min_0_Max_9() {
        boolean checkRandomDomain = true;

        for(int i=0; i<10000; i++) {
            int random = RandomUtils.nextInt(0, 9);
            if(random < 0 || random >= 10) {
                checkRandomDomain = false;
                break;
            }
        }

        assertThat(checkRandomDomain).isEqualTo(true);
    }

}