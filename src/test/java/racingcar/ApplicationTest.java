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
    void 자동차명이_6글자_이상일_때에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 자동차명이_입력되지_않았을_때에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,,java");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 자동차명에_공백이_포함되었을_때에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,ja va");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 자동차명이_중복될_때에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,pobi,java");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 횟수가_숫자가_아닌_경우에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,java", "문자열 값");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 횟수가_1미만인_경우에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,java", "0");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
