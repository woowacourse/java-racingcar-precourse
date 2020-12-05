package racingcar;

import domain.Participants;
import utils.DigitStrategy;

public class Race {
    private Participants participants;
    private int round;

    private Race(Participants participants, int round) {
        this.participants = participants;
        this.round = round;
    }

    public static Race of(Participants participants, int round) {
        return new Race(participants, round);
    }

    public RaceResult startRace(DigitStrategy digitStrategy) {
        RaceResult raceResult = RaceResult.newInstance();
        for (int i = 0; i < round; i++) {
            participants.run(digitStrategy);
            raceResult.writeLog(participants);
        }
        raceResult.setWinnersAmongParticipants(participants);
        return raceResult;
    }


}
