import domain.Car;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car("pobi");
        CarTest.testDecideMoveOrNot(car);
    }

    private static void testDecideMoveOrNot(Car car) {
        int currentPosition = car.getPosition();
        car.decideMoveOrNot();
        int newPosition = car.getPosition();
        int distance = 1;
        int testCount = 100;
        for (int i = 0; i < testCount; i++) {
            assert ((newPosition == currentPosition)
                || (newPosition == currentPosition + distance));
        }
    }
}
