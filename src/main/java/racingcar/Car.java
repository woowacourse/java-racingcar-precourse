package racingcar;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        this.position++;
    }

    public String printPosition() {
        StringBuilder p = new StringBuilder();
        p.append(name);
        p.append(Constant.STANDARD_FOR_EXECUTION_RESULT);
        for (int i = 0; i < position; i++) {
            p.append(Constant.LETTERS_FOR_POSITION);
        }
        p.append("\n");

        return p.toString();
    }

    @Override
    public int compareTo(Car c) {
        return c.position - this.position;
    }

    public String getName(){
        return this.name;
    }
}
