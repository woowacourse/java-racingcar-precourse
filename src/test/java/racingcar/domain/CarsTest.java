package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    public static final String NEW_LINE = System.lineSeparator();

    Cars cars;

    @BeforeEach
    void setUp() {
        this.cars = Cars.createByNames("1,2,3");
    }

    @DisplayName("경기 결과를 문자열로 반환 테스트")
    @Test
    void getGameRecord() {
        cars.move(new Engines("000"));
        assertThat(cars.getGameRecord()).isEqualTo("1 : " + NEW_LINE + "2 : " + NEW_LINE + "3 : ");
        cars.move(new Engines("444"));
        assertThat(cars.getGameRecord()).isEqualTo("1 : -" + NEW_LINE + "2 : -" + NEW_LINE + "3 : -");
        cars.move(new Engines("349"));
        assertThat(cars.getGameRecord()).isEqualTo("1 : -" + NEW_LINE + "2 : --" + NEW_LINE + "3 : --");
    }

    @DisplayName("우승자 문자열로 반환 테스트")
    @Test
    void getWinner() {
        cars.move(new Engines("012"));
        assertThat(cars.getWinner()).isEqualTo("1 2 3");
        cars.move(new Engines("049"));
        assertThat(cars.getWinner()).isEqualTo("2 3");
        cars.move(new Engines("034"));
        assertThat(cars.getWinner()).isEqualTo("3");
    }
}
