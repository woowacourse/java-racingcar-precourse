package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static racingcar.TestConstant.*;
import static racingcar.TestConstant.MOVED;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarsTest {

    Cars cars = new Cars();

    @BeforeAll
    void setUp() {
        cars.removeAll();
        cars.saveCars("jae,hun,choi");
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(STOP, MOVING_FORWARD, MOVING_FORWARD);
            cars.updateCarPosition();
        }
    }

    @DisplayName("저장된 Cars 값을 가져온다")
    @Test
    void getAll(){
        List<Car> findCars = cars.getAllCars();

        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(findCars.size()).isEqualTo(3);
            soft.assertThat(findCars.get(0).getName()).isEqualTo("jae");
            soft.assertThat(findCars.get(1).getName()).isEqualTo("hun");
            soft.assertThat(findCars.get(2).getName()).isEqualTo("choi");
        });
    }

    @DisplayName("숫자에 따라 차량 포지션을 업데이트한다")
    @Test
    void updateCarPosition() {
        List<Car> findCars = cars.getAllCars();

        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(findCars.get(0).getPosition()).isEqualTo(STAY);
            soft.assertThat(findCars.get(1).getPosition()).isEqualTo(MOVED);
            soft.assertThat(findCars.get(2).getPosition()).isEqualTo(MOVED);
        });
    }

    @DisplayName("승자 찾기")
    @Test
    void findWinners() {
        List<Car> winners = cars.getWinners();

        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(winners.size()).isEqualTo(2);
            soft.assertThat(winners.get(0).getName()).isEqualTo("hun");
            soft.assertThat(winners.get(1).getName()).isEqualTo("choi");
        });

    }

    @DisplayName("자동차 저장 길이초과_실패")
    @Test
    void save_cars_range_false() {
        assertThrows(IllegalArgumentException.class, ()
                -> cars.saveCars("jae,hun,choizzz"));
    }

    @DisplayName("자동차 저장 중복이름_실패")
    @Test
    void save_cars_duplicate_false() {
        assertThrows(IllegalArgumentException.class, ()
                -> cars.saveCars("jae,hun,hun"));
    }

    @DisplayName("자동차 저장 빈칸입력_실패")
    @Test
    void save_cars_blank_false() {
        assertThrows(IllegalArgumentException.class, ()
                -> cars.saveCars("jae,hun, "));
    }

    @AfterAll
    void tearDown() {
        cars.removeAll();
    }
}
