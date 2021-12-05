package dto;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    @DisplayName("승자(들)의 이름을 반환한다.")
    void getWinnerNames() {
        Car firstWinner = new Car("Chris");
        Car secondWinner = new Car("Henry");
        List<Car> winnerCars = Arrays.asList(firstWinner, secondWinner);
        Winners winners = new Winners(winnerCars);
        List<String> actual = winners.getWinnerNames();
        List<String> expected = Arrays.asList("Chris", "Henry");
        assertThat(actual).isEqualTo(expected);
    }
}