package racingcar;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class TrackTest {

    @Test
    public void testCreate() {
        Track track = Track.makeTrack();
        Scanner scanner = new Scanner(System.in);
        track.start(scanner);
    }
}
