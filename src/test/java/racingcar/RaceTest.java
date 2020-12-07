package racingcar;

import domain.Car;
import domain.Participants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputDigitStrategy;
import utils.RandomDigitStrategy;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceTest {
    final static int MIN_RUNNABLE = 4;

    @Test
    @DisplayName("라운드 횟수 당 현재 위치가 잘 증가되는 지 확인")
    public void testPositionPerRound() throws Exception {
        //given
        Participants participants = Participants.from(createCars());
        final int ROUND = 3;
        Race race = Race.of(participants, ROUND);
        //when
        race.startRace(new InputDigitStrategy(MIN_RUNNABLE));
        //then
        participants.getParticipants()
                .forEach(car -> assertEquals(car.getCurrentPosition(), ROUND));
    }

    @Test
    @DisplayName("위너가 리턴 되는 지 확인")
    public void testWinnerCar() throws Exception {
        //given
        List<String> winners = Arrays.asList("Bomin", "Daniel");
        Participants participants = Participants.from(createCars());
        final int ROUND = 3;
        participants.getParticipants().stream().filter(car -> winners.contains(car.getName()))
                .forEach(car -> car.run(MIN_RUNNABLE));
        Race race = Race.of(participants, ROUND);
        //when
        RaceResult raceResult = race.startRace(new InputDigitStrategy(MIN_RUNNABLE));
        //then
        Assertions.assertThat(winners).isEqualTo(raceResult.getWinnersName());
    }

    @Test
    @DisplayName("랜덤 레이스 상황이 화면에 잘 출력 되는 지 확인")
    public void testRandomRace() throws Exception {
        //given
        Participants participants = Participants.from(createCars());
        final int ROUND = 5;
        //when
        Race race = Race.of(participants, ROUND);
        //then
        RaceResult raceResult = race.startRace(new RandomDigitStrategy());
        System.out.println(raceResult.getLog());
    }

    private List<Car> createCars() {
        return Arrays.asList(
                new Car("Bomin"),
                new Car("Daniel"),
                new Car("Francisco")
        );
    }
}