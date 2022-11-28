package racingcar.domain.movables.engine;

import racingcar.domain.Winners;

import java.util.List;

public interface Movables {
    void race();
    
    Winners winners();
    
    List<String> movablesName();
    
    List<Integer> movablesPosition();
}
