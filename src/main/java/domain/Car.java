package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void move(){
        randomNumber();
    }

    private void randomNumber() {
        int number = (int) (Math.random() * 10); // 0~9
        checkMove(number);
    }

    private void checkMove(int number) {
        if (number >= 4) {
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
