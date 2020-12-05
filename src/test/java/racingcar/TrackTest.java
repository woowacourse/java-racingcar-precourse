package racingcar;

import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class TrackTest {

    @Test
    public void testCreate() {
        Track track = new Track(new ArrayList<>(), new ArrayList<>());
        Scanner scanner = new Scanner(System.in);
        track.start(scanner);
    }
}
