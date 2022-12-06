package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    private static final String EXCEPTION_MESSAGE_CARS_DUPLICATED_NAME = "[ERROR] 자동차 이름은 중복될 수 없습니다";

    @DisplayName("Cars 객체를 성공적으로 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobii,pop,p", "p", "pob,pb,bb,dcd,wqwqg,xvd,aw,be", "pb,,pob,,,bo"})
    void createCarsSuccess(String input) {
        boolean result = true;
        try{
            Cars.createCarNameByWord(input);
        }catch (IllegalArgumentException exception) {
            result = false;
        }
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("Cars 객체 생성시 중복되는 자동차 이름이있다")
    @ParameterizedTest
    @ValueSource(strings = {"d,gme,d", "wwwww,ef,weah,wwwww,wwwww", "d,d,d,d,d,d,d,d,d,d"})
    void createCarsByDuplicatedName (String input) {
        assertThatThrownBy(() -> Cars.createCarNameByWord(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_CARS_DUPLICATED_NAME);
    }
}
