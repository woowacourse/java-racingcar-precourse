package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    ComputeRandomNumber computeRandomNumber = new ComputeRandomNumber();
    public Car(String name) {
        this.name = name;
    }
    public void decidePositionNumber(){
        if(computeRandomNumber.informCanFoward()) {
            this.position += 1;
        }
    }
    public String getName(){
        return this.name;
    }
    public int getPosition(){
        return this.position;
    }

    // 추가 기능 구현
}
