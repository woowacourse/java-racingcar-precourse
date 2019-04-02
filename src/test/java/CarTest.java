import junit.framework.TestCase;
import org.junit.Test;
import domain.Car;

public class CarTest extends TestCase {

    /* 자동차의 전진 기능을 테스트합니다. */
    @Test
    public void testMoveForward() throws Exception {
        Car testCar = new Car("test");
        testCar.moveForward();
        assertEquals(1, testCar.getPosition());
        testCar.moveForward();
        assertEquals(2, testCar.getPosition());
    }

    /* 자동차가 이름을 갖는지 테스트합니다. */
    @Test
    public void testName() throws Exception {
        Car testCar = new Car("abc");
        Car testCar2 = new Car("1234");
        Car testCar3 = new Car("abc");

        assertFalse(testCar.name == testCar2.name);
        assertEquals(testCar.name, testCar3.name);
    }
}
