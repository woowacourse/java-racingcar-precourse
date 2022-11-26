package racingcar.domain.movables.engine;

import racingcar.domain.winners.engine.Winners;

import java.util.List;

public interface Movables {
    void race();
    
    Winners winners();
    
    List<Movable> movables();
}
