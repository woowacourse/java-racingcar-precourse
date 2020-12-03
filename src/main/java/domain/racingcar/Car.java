package domain.racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public int increasePosition(Integer randomNumber){
        if(randomNumber>=4){
            this.position++;
        }
        return this.position;
    }
}
