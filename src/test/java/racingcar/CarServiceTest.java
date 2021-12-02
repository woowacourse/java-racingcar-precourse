package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int MOVED = 1;
    private static final int STAY = 0;
    private static final int SAVED = 3;

    CarRepository carRepository = CarRepository.getInstance();
    CarService carService = new CarService(carRepository);

    @DisplayName("자동차 저장_성공")
    @Test
    void save_cars_true() {
        carService.saveCars("jae,hun,choi");
        List<Car> findCars = carService.findAllCars();

        assertThat(findCars.size()).isEqualTo(SAVED);
    }

    @DisplayName("자동차 저장 길이초과_실패")
    @Test
    void save_cars_range_false() {
        assertThrows(IllegalArgumentException.class, ()
                -> carService.saveCars("jae,hun,choizzz"));
    }

    @DisplayName("자동차 저장 중복이름_실패")
    @Test
    void save_cars_duplicate_false() {
        assertThrows(IllegalArgumentException.class, ()
                -> carService.saveCars("jae,hun,hun"));
    }

    @DisplayName("자동차 저장 빈칸입력_실패")
    @Test
    void save_cars_blank_false() {
        assertThrows(IllegalArgumentException.class, ()
                -> carService.saveCars("jae,hun, "));
    }

    @DisplayName("자동차 위치 업데이트")
    @Test
    void update_car_position() {
        carService.saveCars("jae,hun,choi");
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(STOP, MOVING_FORWARD, MOVING_FORWARD);
            carService.updateCarPosition();
        }
        List<Car> findCars = carService.findAllCars();

        assertThat(findCars.get(0).getPosition()).isEqualTo(STAY);
        assertThat(findCars.get(1).getPosition()).isEqualTo(MOVED);
        assertThat(findCars.get(2).getPosition()).isEqualTo(MOVED);
    }

    @DisplayName("승자 확인")
    @Test
    void find_winners() {
        carService.saveCars("jae,hun,choi");
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(STOP, MOVING_FORWARD, MOVING_FORWARD);
            carService.updateCarPosition();
        }

        List<Car> winners = carService.findWinners();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("hun");
        assertThat(winners.get(1).getName()).isEqualTo("choi");
    }

    @AfterEach
    void tearDown() {
        carRepository.clear();
    }

}