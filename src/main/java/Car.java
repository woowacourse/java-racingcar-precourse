public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    int printMovingForward() {
        int randomValue = (int) (Math.random() * 10);

        System.out.print(name + " : ");
        if (randomValue >= 4) {
            this.position++;
            for (int i = 0; i < this.position; i++) {
                System.out.print("-");
            }
            return 1;
        }
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        return 0;
    }

    public String toString() {
        return name;
    }
}
