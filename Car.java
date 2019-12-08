public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(int strideLength) {
        this.position += strideLength;
    }

    public boolean nameLongerThan(int maxLength) {
        return this.name.length() > maxLength;
    }


    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
