package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputDigitStrategy;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {
    private static final int MIN_RUNNABLE_NUM = 4;

    @Test
    @DisplayName("Participants 도메인 생성 확인")
    public void testParticipate() throws Exception {
        //given
        List<Car> carList = createCarList();
        //when
        Participants participants = Participants.from(carList);
        //then
        Assertions.assertThat(participants.getParticipants()).isEqualTo(carList);
    }

    @Test
    @DisplayName("run 값이 잘 올라가는 지 확인")
    public void testParticipateRun() throws Exception {
        //given
        List<Car> carList = createCarList();
        Participants participants = Participants.from(carList);
        //when
        participants.run(new InputDigitStrategy(MIN_RUNNABLE_NUM));
        //then
        participants.getParticipants()
                .forEach(car -> assertEquals(1, car.getCurrentPosition()));
    }

    private List<Car> createCarList() {
        return Arrays.asList(
                new Car("Bomin"),
                new Car("Daniel"),
                new Car("Prim")
        );
    }

}