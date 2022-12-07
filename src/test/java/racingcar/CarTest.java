package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Car 클래스")
class CarTest {

    @Nested
    @DisplayName("자동차 이름 유효성 검사")
    class Describe_Car_Init {

        @Test
        @DisplayName("이름이 5자 이하면 초기화 성공")
        void 성공_테스트() {
            Car fives = new Car("fives");
            assertThat(fives).isNotNull();
        }

        @Test
        @DisplayName("이름이 5자 초과이면 예외처리한다.")
        void 실패_테스트() {
            //given
            assertThatThrownBy(() -> new Car("sixCar"))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("전진 테스트")
    class Describe_MoveOrStop {

        @Test
        @DisplayName("들어온 값이 4 이상이면 전진한다.")
        void 자동차_전진_테스트() {
            //given
            Car pobi = new Car("pobi");
            //when
            int prePosition = pobi.getCurrentPosition();
            pobi.moveOrStop(4);
            //then
            int currentPostion = pobi.getCurrentPosition();
            assertThat(prePosition + 1).isEqualTo(currentPostion);
        }

        @Test
        @DisplayName("들어온 값이 4 미만이면 정지한다.")
        void 자동차_정지_테스트() {
            //given
            Car pobi = new Car("pobi");
            //when
            int prePosition = pobi.getCurrentPosition();
            pobi.moveOrStop(3);
            //then
            int currentPostion = pobi.getCurrentPosition();
            assertThat(prePosition).isEqualTo(currentPostion);
        }
    }

}
