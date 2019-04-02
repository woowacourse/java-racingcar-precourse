package domain;

public class Car {

    private final String name;
    private int position = 0;
    private int prevPosition = 0;

    public Car(String name) {
        this.name = name;
    }

    public void ForwardOrStop(int random) {
        prevPosition = position;

        ForwardCarIfRandomNumAboveMeanOfUpperAndLowerBound(random);
    }

    public void ForwardCarIfRandomNumAboveMeanOfUpperAndLowerBound(int random) {
        int mean = (RandomNumGenerator.RandomNumBound.UPPER.getBound()
                + RandomNumGenerator.RandomNumBound.LOWER.getBound()) / 2;
        if (random >= mean) {
            position++;
        }
    }

    public boolean doesCarMoved() {
        return position > prevPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
