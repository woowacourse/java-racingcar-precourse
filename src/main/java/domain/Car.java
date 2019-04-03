package domain;

public class Car {
    public final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String outName(){
        return name;
    }

    // 추가 기능 구현
}
