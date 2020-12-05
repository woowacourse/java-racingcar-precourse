package racingcar;

import domain.Car;
import domain.Participants;
import domain.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private Winners winners;
    private RaceLog raceLog;

    private RaceResult() {
        raceLog = RaceLog.newInstance();
    }

    public static RaceResult newInstance() {
        return new RaceResult();
    }

    public List<String> getWinnersName() {
        return winners.getWinnersName();
    }

    public void writeLog(Participants participants) {
        raceLog.writeLog(participants);
    }

    public void setWinnersAmongParticipants(Participants participants) {
        Winners winners = Winners.of(filterWinner(participants));
        this.winners = winners;
    }

    private List<Car> filterWinner(Participants participants) {
        int maxPosition = getMaxPosition(participants);
        return participants.getParticipants()
                .stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(Participants participants) {
        return participants.getParticipants()
                .stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .getAsInt();
    }


    public String getLog() {
        return raceLog.getLog();
    }
}
