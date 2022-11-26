package racingcar.domain.positive;

public interface Positive {
    Positive increase();
    
    int number();
    
    // same 추가 (position 다수 우승자, tryNumber 게임 종료 조건)
}
