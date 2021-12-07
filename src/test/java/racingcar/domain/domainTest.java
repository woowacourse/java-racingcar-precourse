package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.Application;

class domainTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    @Test
    void 이름_공백_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,,javaji");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 자동차_숫자_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 이름_중복_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,pobi,sudal");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 마지막_쉼표_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,sudal,");
                assertThat(output()).contains(INPUT_MESSAGE);
            }
        );
    }

    @Test
    void 반복_횟수_범위_예러_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,sudal", "-5");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 반복_횟수_문자_예러_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,sudal", "one");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}