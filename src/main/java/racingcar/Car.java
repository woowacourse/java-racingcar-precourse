package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void moveCarForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getProgressBar() {
        String progressBar = "";
        for (int i = 0; i < position; i++) {
            progressBar += "-";
        }

        return progressBar;
    }

}
