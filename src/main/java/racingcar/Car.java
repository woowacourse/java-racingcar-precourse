package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    private GasTank gasTank;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void forward() {
        if(gasTank.isEnoughGas()){
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
