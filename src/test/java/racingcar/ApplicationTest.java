package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    public void 이름_중복_예외_처리() throws Exception {
        assertSimpleTest(
                () -> {
                    runException("pobi,java,tco,pobi");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    public void 이름_없음에_대한_예외_처리() throws Exception {
        assertSimpleTest(
                () -> {
                    runException("pobi,,java,tco");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    public void 이름_공백_예외_처리() throws Exception {
        assertSimpleTest(
                () -> {
                    runException("po bi,tco");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    public void pickNumberInRange_테스트() throws Exception {
        //given
        int num1 = 0;
        int num2 = 9;

        //when
        int result = pickNumberInRange(num1, num2);

        //then
        assertThat(result).isGreaterThanOrEqualTo(num1).isLessThanOrEqualTo(num2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
