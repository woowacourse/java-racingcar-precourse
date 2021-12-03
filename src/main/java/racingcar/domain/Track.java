package racingcar.domain;

import java.util.stream.IntStream;

public class Track {
    public static final String NEW_LINE = System.lineSeparator();
    public static final int START_INDEX = 0;

    private final Cars cars;
    private final Recorder recorder;

    private Track(String carsName) {
        this.cars = Cars.createByNames(carsName);
        this.recorder = new Recorder();
    }

    public static Track createByCarsName(String carsName) {
        return new Track(carsName);
    }

    public String getGameRecord() {
        return recorder.getRecord();
    }

    public void play(EngineRepository engineRepository) {
        IntStream.range(START_INDEX, engineRepository.size()).forEach(index -> {
            cars.move(engineRepository.get(index));
            recorder.record(cars.getGameRecord() + NEW_LINE);
        });
    }

    public int getCarsCount() {
        return cars.getCarsCount();
    }

    public String getWinner() {
        return cars.getWinner();
    }
}
