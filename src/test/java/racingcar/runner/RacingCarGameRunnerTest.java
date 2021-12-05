package racingcar.runner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class RacingCarGameRunnerTest {

    final static int GO = 5;
    ByteArrayOutputStream out;
    PrintStream orig;

    @BeforeEach
    void name() {
        orig = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(orig);
    }

    @DisplayName("게임 동작을 테스트한다.")
    @Test
    void gameRunnerTest() {
        String tc = "abc,bcd\n3\n";
        try (MockedStatic<Randoms> randoms = mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(GO, GO, GO, GO, GO, GO);
            System.setIn(new ByteArrayInputStream(tc.getBytes()));
            RacingCarGameRunner runner = new RacingCarGameRunner();
            runner.run();
            assertThat(out.toString()).contains("abc,bcd");
        }
    }
}