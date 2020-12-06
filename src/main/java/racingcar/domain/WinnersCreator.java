package racingcar.domain;

import racingcar.exceptions.NullPositionException;

import java.util.List;
import java.util.stream.Collectors;

public class WinnersCreator {
    private WinnersCreator() {
    }

    public static Winners createWinners(RacingGame racingGame) {
        List<String> winnersNames = getWinnersNames(racingGame);
        return new Winners(winnersNames);
    }

    private static List<String> getWinnersNames(RacingGame racingGame) {
        int maxPosition = getMaxPosition(racingGame);
        return racingGame.getCars().stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(RacingGame racingGame) {
        return racingGame.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NullPositionException::new);
    }
}
