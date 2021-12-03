package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class GameBoy {
    public static final int START_INDEX = 0;
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    public static final String NEW_LINE = System.lineSeparator();
    public static final String RESULT_PREFIX = NEW_LINE + "실행 결과" + NEW_LINE;
    public static final String WINNER_PREFIX = "최종 우승자 : ";
    public static final String SPACE_STRING = " ";
    public static final String COMMA = ",";

    private final Track track;
    private EngineRepository engineRepository;

    public GameBoy(String names) {
        this.track = Track.createByCarsName(names);
    }

    public void insertToken(Token token) {
        makeEngineRepository(token);
    }

    public void play() {
        track.play(engineRepository);
    }

    public String showResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RESULT_PREFIX);
        stringBuilder.append(track.getGameRecord());
        stringBuilder.append(WINNER_PREFIX);
        stringBuilder.append(track.getWinner().replaceAll(SPACE_STRING, COMMA + SPACE_STRING));
        return stringBuilder.toString();
    }

    private void makeEngineRepository(Token token) {
        List<String> values = new ArrayList<>();
        while (token.hasNext()) {
            values.add(makeRandom());
        }
        this.engineRepository = new EngineRepository(values);
    }

    private String makeRandom() {
        StringBuilder stringBuilder = new StringBuilder();
        int endIndex = track.getCarsCount();
        IntStream.range(START_INDEX, endIndex)
            .forEach(i -> stringBuilder.append(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)));
        return stringBuilder.toString();
    }
}
