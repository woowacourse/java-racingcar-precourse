package racing.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void run() {
        position++;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append(" : ");

        for (int i = 0; i < position; i++) {
            sb.append('-');
        }

        return sb.toString();
    }
}
