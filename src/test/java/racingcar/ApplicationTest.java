package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String FINAL_RESULT_MESSAGE = "최종 우승자";

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,javaji");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 이름_예외후_재입력() {
        assertSimpleTest(
            () -> {
                runException("pobi,javaji", "pobi,jvji", "3");
                assertThat(output()).contains(ERROR_MESSAGE);
                assertThat(output()).contains(FINAL_RESULT_MESSAGE);
            }
        );
    }

    @Test
    void 반복_횟수_예외후_재입력() {
        assertSimpleTest(
            () -> {
                runException("pobi,jvji", "-5", "5");
                assertThat(output()).contains(ERROR_MESSAGE);
                assertThat(output()).contains(FINAL_RESULT_MESSAGE);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
