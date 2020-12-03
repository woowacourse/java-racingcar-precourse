package domain;

public class Car {
    private final int RUNNABLE_MIN_NUM = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void run(int inputNumber) {
        if (runnable(inputNumber)) {
            position++;
        }
    }

    private boolean runnable(int inputNumber) {
        return inputNumber >= RUNNABLE_MIN_NUM;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return position;
    }
}
