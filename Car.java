public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(int strideLength) {
        this.position += strideLength;
    }

    public boolean hasNameLongerThan(int maxLength) {
        return this.name.length() > maxLength;
    }

    public boolean isMaxPosition(int maxDistance) {
        return this.position == maxDistance;
    }

    public String getStatus() {
        String result = this.name + " : ";
        for (int i = 0; i < this.position; i++) {
            result += "-";
        }
        return result;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
