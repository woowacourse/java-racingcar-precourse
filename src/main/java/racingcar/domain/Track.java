package racingcar.domain;

import java.util.stream.IntStream;

public class Track {
    public static final String NEW_LINE = System.lineSeparator();
    public static final int START_INDEX = 0;

    private final Cars cars;
    private String gameRecord = "";

    public Track(String value) {
        this.cars = Cars.createByNames(value);
    }

    public String getGameRecord() {
        return this.gameRecord;
    }

    public void play(EngineRepository engineRepository) {
        IntStream.range(START_INDEX, engineRepository.size()).forEach(index -> {
            cars.move(engineRepository.get(index));
            gameRecord += cars.getGameRecord() + NEW_LINE + NEW_LINE;
        });
    }

    public int getCarsCount() {
        return cars.getCarsCount();
    }
}
