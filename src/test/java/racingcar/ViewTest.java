package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.View.Relay;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest extends NsTest {

    private final Relay relay = new Relay();

    @Test
    @DisplayName("차량등록입력 기능 확인")
    void carAttendTest() {
        String testInput = "A,B,C,D,rust,js,java,c,swift";
        List<Car> parsedCars = relay.toCarList(testInput);

        int carCount = testInput.split(",").length;

        assertThat(parsedCars.size()).isEqualTo(carCount);

        for (Car car : parsedCars) assertThat(testInput).contains(car.getName());
    }

    @Test
    @DisplayName("경주 상황 출력 정합성을 확인")
    void relayLapseTest() {
        assertRandomNumberInRangeTest(() -> {
            run("A,B", "3");

            String output = output();
            assertThat(output).contains("A : -", "A : --", "A : ---");
            assertThat(output).doesNotContain("B : -", "B : --", "B : ---");
        }, 9, 1, 9, 1, 9, 1);
    }

    @Test
    @DisplayName("최종우승자 출력기능 확인")
    void awardingTest() {
        List<Car> cars = new ArrayList<>();

        List<String> carNames = List.of("A", "B", "C");
        String expectedWinner = "최종 우승자 : A";

        for (String name : carNames) cars.add(new Car(name));

        assertRandomNumberInRangeTest(() -> {
            for (Car car : cars) car.accelerate();
            assertThat(relay.winners(cars)).contains(expectedWinner);
        }, 9, 0, 0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
