package racingcar;

import java.util.Scanner;
import org.junit.jupiter.api.Test;
import utils.InputUtils;
import utils.OutputUtils;

public class TrackTest {

    @Test
    public void testCreate() {
        Track track = new Track();
        Scanner scanner = new Scanner(System.in);
        track.start(scanner);
    }
}
