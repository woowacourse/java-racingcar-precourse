package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RacingCarGameInitializerTest {

    private RacingCarGameInitializer racingCarGameInitializer;
    private Random random;

    @BeforeEach
    void setUp() {
        List<String> names = new ArrayList<>();
        names.add("첫번째차");
        names.add("두번쨰차");
        names.add("세번째차");
        racingCarGameInitializer = new RacingCarGameInitializer(names);

        random = new Random();
    }

    @Test
    void cars_runOneTime() {
        racingCarGameInitializer.runOneTime(random);
    }

    @Test
    void cars_showCarsStatus() {
        racingCarGameInitializer.runOneTime(random);
        racingCarGameInitializer.runOneTime(random);
        racingCarGameInitializer.runOneTime(random);

        racingCarGameInitializer.showCarsStatus();
    }
}
