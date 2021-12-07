package racingcar;

public class Car {
    private static final char FORWARD_SIGN = '-';
    private static final String NAME_SEPARATOR = " : ";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public void moveForward() {
        position += 1;
    }

    public void moveResult() {
        System.out.print(name + NAME_SEPARATOR);
        for (int i = 0; i < position; i++) {
            System.out.print(FORWARD_SIGN);
        }
        System.out.println();
    }

    public String[] getResult() {
        String[] result = {name, Integer.toString(position)};

        return result;
    }
}
