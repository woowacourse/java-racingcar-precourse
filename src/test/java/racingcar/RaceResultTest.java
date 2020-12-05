package racingcar;

import domain.Car;
import domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {
    @Test
    @DisplayName("우승자가 한 명일 때")
    public void testOneWinner() throws Exception {
        //given
        final String WINNER_NAME = "Bomin";
        final int RUNNABLE_NUM = 5;
        Participants participants = Participants.of(createMultiCars());
        //when
        participants.getParticipants().stream()
                .filter(car -> car.getName().equals(WINNER_NAME))
                .forEach(car -> car.run(RUNNABLE_NUM));
        RaceResult raceResult = RaceResult.newInstance();
        raceResult.setWinnersAmongParticipants(participants);
//        then
        assertThat(raceResult.getWinnersName()).contains(WINNER_NAME);
    }

    @Test
    @DisplayName("우승자가 여러 명 일 때")
    public void testMultiWinners() throws Exception {
        //given
        final List<String> WINNER_NAMES = Arrays.asList("Bomin", "Daniel");
        final int RUNNABLE_NUM = 5;
        Participants participants = Participants.of(createMultiCars());
        //when
        participants.getParticipants().stream()
                .filter(car -> WINNER_NAMES.contains(car.getName()))
                .forEach(car -> car.run(RUNNABLE_NUM));
        RaceResult raceResult = RaceResult.newInstance();
        raceResult.setWinnersAmongParticipants(participants);
        //then
        assertThat(WINNER_NAMES).isEqualTo(raceResult.getWinnersName());
    }

    public List<Car> createMultiCars() {
        return Arrays.asList(
                new Car("Bomin"),
                new Car("Daniel"),
                new Car("Francisco"),
                new Car("Scott")
        );
    }

}