package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void goForward() {
        this.position++;
    }

    public void stop() {

    }

    public String getPosition() {
        char[] pos = new char[this.position];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = '-';
        }
        return String.copyValueOf(pos);
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 9 + 1);
    }
}
