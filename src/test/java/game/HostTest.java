package game;

import game.Host;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class HostTest {

    private Host host;
    private Random random;

    @BeforeEach
    void setUp() {
        List<String> names = new ArrayList<>();
        names.add("첫번째차");
        names.add("두번쨰차");
        names.add("세번째차");
        host = new Host(names);

        random = new Random();
    }

    @Test
    void cars_runOneTime() {
        host.runOneTime(random);
    }

    @Test
    void cars_showCarsStatus() {
        host.runOneTime(random);
        host.runOneTime(random);
        host.runOneTime(random);

        host.showCarsStatus();
    }
}