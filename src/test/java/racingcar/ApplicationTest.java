package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 자동차_전진_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                String name = "Test";
                int tryNumber = 3;
                Car car = createCarAndTry(name, tryNumber);

                car.printStatus();
                assertThat(output()).contains(name + " : --");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_준비위치로_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                String name = "Test";
                int tryNumber = 3;
                Car car = createCarAndTry(name, tryNumber);
                car.setReady();

                car.printStatus();
                assertThat(output()).contains(name + " :");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    public Car createCarAndTry(String carName, int tryNumber) {
        Car car = new Car(carName);
        for (int i = 0; i < tryNumber; i++) {
            car.tryMove();
        }
        return car;
    }

    @Test
    void 자동차_비교기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                Car fastCar = new Car("fast");
                Car slowCar = new Car("slow");

                fastCar.tryMove();  //fast:1, slow:0
                assertThat(fastCar.compareTo(slowCar)).isGreaterThan(0);

                slowCar.tryMove();  //fast:1, slow:1
                assertThat(fastCar.compareTo(slowCar)).isEqualTo(0);

                slowCar.tryMove();  //fast:1, slow:2
                assertThat(fastCar.compareTo(slowCar)).isLessThan(0);
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
