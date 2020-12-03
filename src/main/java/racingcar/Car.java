package racingcar;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameRange(name);
        this.name = name;
    }

    private void validateNameRange(String name) {
        // 5자 이하만 가능
        if (5 < name.length()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public void moveForward() {
        position += 1;
    }

    public void printStatus() {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < position; i++) {
            progress.append("-");
        }

        System.out.println(name + " : " + progress);
    }


}
