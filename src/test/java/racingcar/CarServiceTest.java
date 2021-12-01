package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {

    CarService carService = new CarService(CarRepository.getInstance());

    @DisplayName("자동차 저장_성공")
    @Test
    void save_cars_true(){
        carService.saveCars("jae, hun, choi");
        List<Car> findCars = carService.findAllCar();

        assertThat(findCars.size()).isEqualTo(3);
    }

    @DisplayName("자동차 저장_실패")
    @Test
    void save_cars_false(){
        assertThrows(IllegalArgumentException.class, ()
                -> carService.saveCars("jae, hun, choizzz"));
    }

    @DisplayName("자동차 위치 업데이트")
    @Test
    void update_car_position(){
        carService.saveCars("jae, hun, choi");
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)){
            mock.when(() -> Randoms.pickNumberInRange(anyInt(),anyInt())).thenReturn(3,4,5);
            carService.updateCarPosition();
        }
        List<Car> findCars = carService.findAllCar();

        assertThat(findCars.get(0).getPosition()).isEqualTo(0);
        assertThat(findCars.get(1).getPosition()).isEqualTo(1);
        assertThat(findCars.get(2).getPosition()).isEqualTo(1);
    }

}