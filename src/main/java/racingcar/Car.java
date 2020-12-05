package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    public GasTank gasTank;

    public Car(String name, GasTank gasTank) {
        this.name = name;
        this.gasTank = gasTank;
    }

    // 추가 기능 구현

    public void tryForward() {
        if(gasTank.isEnoughGas()){
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
