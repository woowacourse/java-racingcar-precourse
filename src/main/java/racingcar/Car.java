public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void printResult() {
        for (int i = 0; i < this.position ; i++) {
            System.out.println("-");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
