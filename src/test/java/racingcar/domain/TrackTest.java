package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrackTest {
    Track track;

    @BeforeEach
    void setUp() {
        this.track = new Track("1,2,3");
    }

    @DisplayName("1라운드 경기내용 문자열 반환 테스트")
    @Test
    void getOneRoundGameRecord() {
        track.play(new EngineRepository(Arrays.asList("444")));
        assertThat(track.getGameRecord()).isEqualTo("1 : -\n2 : -\n3 : -\n\n");
    }

    @DisplayName("2라운드 경기내용 문자열 반환 테스트")
    @Test
    void getTwoRoundsGameRecord() {
        track.play(new EngineRepository(Arrays.asList("456", "999")));
        assertThat(track.getGameRecord())
            .isEqualTo("1 : -\n2 : -\n3 : -\n\n1 : --\n2 : --\n3 : --\n\n");
    }

    @DisplayName("3라운드 경기내용 문자열 반환 테스트")
    @Test
    void getThreeRoundsGameRecord() {
        track.play(new EngineRepository(Arrays.asList("456", "789", "012")));
        assertThat(track.getGameRecord())
            .isEqualTo("1 : -\n2 : -\n3 : -\n\n1 : --\n2 : --\n3 : --\n\n1 : --\n2 : --\n3 : --\n\n");
    }
}
