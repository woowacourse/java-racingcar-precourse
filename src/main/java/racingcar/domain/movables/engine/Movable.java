package racingcar.domain.movables.engine;

import racingcar.domain.movestrategy.MoveStrategy;

public interface Movable {
    void move(MoveStrategy moveStrategy);
    
    String name();
    
    int position();
}
