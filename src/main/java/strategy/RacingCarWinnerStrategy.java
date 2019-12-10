package strategy;

import model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarWinnerStrategy implements WinnerStrategy<Car> {
    private List<Car> participants;
    private int maxPosition;

    @Override
    public void setParticipants(List<Car> participants) {
        this.participants = participants;
    }

    @Override
    public List<Car> getWinners() {
        this.maxPosition = findMaxPosition();

        return participants.stream()
                .filter(p -> p.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return participants.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }
}
