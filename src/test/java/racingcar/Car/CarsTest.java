package racingcar.Car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    static Cars cars;
    static Car car1;
    static Car car2;
    static Car car3;

    @BeforeAll
    static void setUp() {
        car1 = new Car("A");
        car2 = new Car("B");
        car3 = new Car("C");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        cars = new Cars(carList);
    }

    @DisplayName("progress 출력이 제대로 되는지 확인한다.")
    @Test
    void progess_대쉬출력을_확인() {
        for (int i = 0; i < 10; i++) {
            cars.race();
        }

        int position = car1.getPosition();
        StringBuffer expectedString = new StringBuffer(car1.getName() + " : ");
        for (int i = 0; i < position; i++) {
            expectedString.append("-");
        }

        // expectedString -> like "A : -----"
        assertThat(cars.printProgress()).contains(expectedString.toString());
    }

    @DisplayName("우승자를 잘 찾는지 확인한다.")
    @Test
    void 우승자를_잘_찾는지_확인() {
        for (int i = 0; i < 10; i++) {
            cars.race();
        }

        int[] positions = {car1.getPosition(), car2.getPosition(), car3.getPosition()};
        String[] names = {"A","B","C"};

        int maxPosition = 0;
        for (int position : positions) {
            if (position > maxPosition) {
                maxPosition = position;
            }
        }

        List<String> winners = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            if (positions[i] == maxPosition) {
                winners.add(names[i]);
            }
        }

        assertThat(cars.findWinners()).isEqualTo(winners);
    }
}