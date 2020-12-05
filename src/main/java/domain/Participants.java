package domain;

import utils.DigitStrategy;

import java.util.List;

public class Participants {
    private List<Car> participants;

    private Participants(List<Car> participants) {
        this.participants = participants;
    }

    public static Participants of(List<Car> participants) {
        return new Participants(participants);
    }

    public void run(DigitStrategy digitStrategy) {
        participants.forEach(car -> car.run(digitStrategy.getDigit()));
    }

    public List<Car> getParticipants() {
        return participants;
    }
}
