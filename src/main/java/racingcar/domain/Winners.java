package racingcar.domain;

import racingcar.domain.movables.engine.Movable;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Movable> movables;
    
    public Winners(final List<Movable> movables) {
        this.movables = movables;
    }
    
    public List<String> winnersName() {
        return movables.stream()
                .map(Movable::name)
                .collect(Collectors.toUnmodifiableList());
    }
}
