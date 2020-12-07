package racingcar;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    public void testCreate() {
        Scanner scanner = new Scanner(System.in);
        Racing racing = new Racing();
        racing.start(scanner);
    }
}
