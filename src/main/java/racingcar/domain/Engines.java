package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Engines {
    private final List<Engine> engines;

    public Engines(String value) {
        this.engines = value.chars().map(Character::getNumericValue).mapToObj(Engine::new).collect(Collectors.toList());
    }

    public boolean canOperate(int index) {
        return engines.get(index).canOperate();
    }
}
