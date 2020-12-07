package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final Set<Car> cars = new LinkedHashSet<>();

    public Cars(List<String> participants) {
        validateParticipantsIsZero(participants);
        for (String name : participants) {
            cars.add(new Car(name));
        }
    }

    public Set<Car> getCars() {
        return cars;
    }

    public List<String> getWinnerName() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get()
                .getPosition();
    }

    private void validateParticipantsIsZero(List<String> participants) {
        boolean isParticipantsZero = (participants.size() == 0);
        if (isParticipantsZero) {
            throw new IllegalArgumentException("[ERROR] 게임 인원은 최소 1명 이상이어야 합니다.");
        }
    }
}