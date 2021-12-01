package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engines {
    public static final String EMPTY_STRING = "";

    private final List<Engine> engines;

    public Engines(String value) {
        this.engines = Arrays.stream(value.split(EMPTY_STRING)).mapToInt(Integer::parseInt).boxed()
            .map(Engine::new).collect(Collectors.toList());
    }

    public boolean canOperate(int index) {
        return engines.get(index).canOperate();
    }
}
