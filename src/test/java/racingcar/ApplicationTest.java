package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 이름은 5자 이하만 가능하다.";
    private static final String NAME_DUPLICATED_ERROR_MESSAGE = "[ERROR] 중복된 이름은 사용할 수 없다.";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

    @Test
    void 전진_정지_단독우승() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 전진_정지_복수우승() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi2,woni2", "1");
                assertThat(output()).contains("pobi2 : -", "woni2 : -", "최종 우승자 : pobi2, woni2");
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
         assertSimpleTest(
             () -> {
                 runException("pobi3,javaji3");
                 assertThat(output()).contains(NAME_LENGTH_ERROR_MESSAGE);
            }
         );
    }

    @Test
    void 이름에_대한_중복_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("test,test");
                assertThat(output()).contains(NAME_DUPLICATED_ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 숫자에_대한_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("a,b,c,d,e","1abd");
                assertThat(output()).contains(NUMBER_ERROR_MESSAGE);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
