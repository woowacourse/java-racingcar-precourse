package racing.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    void run() {
        position++;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    boolean isPosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String nameFormat = String.format("%-5s", name);
        sb.append(nameFormat);
        sb.append(" : ");

        for (int i = 0; i < position; i++) {
            sb.append('-');
        }

        return sb.toString();
    }
}
