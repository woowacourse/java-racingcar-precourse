package racingcar.domain.movables.engine;

import racingcar.domain.movestrategy.MoveStrategy;

public interface Movable {
    void move(MoveStrategy moveStrategy);
    
    boolean isPositionSame(int maxPosition);
    
    String name();
    
    int position();
}
