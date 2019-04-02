import junit.framework.TestCase;
import org.junit.Test;
import domain.Car;

public class CarTest extends TestCase {
    /* 자동차의 전진 기능을 테스트합니다. */
    @Test
    public void testMoveForward() throws Exception {
        Car testCar = new Car("pobi");

        testCar.moveForward();
        assertEquals(1, testCar.getPosition());
        testCar.moveForward();
        assertEquals(2, testCar.getPosition());
    }

    /* 자동차가 이름을 갖는지 테스트합니다. */
    @Test
    public void testName() throws Exception {
        Car testCar = new Car("pobi");
        Car testCar2 = new Car("crong");
        Car testCar3 = new Car("pobi");

        assertFalse(testCar.getName() == testCar2.getName());
        assertEquals(testCar.getName(), testCar3.getName());
    }

    /* 자동차가 적절히 자신의 이름과 이동한 거리를 출력하는 지 테스트합니다. */
    @Test
    public void testPrintStatus() throws Exception {
        Car testCar = new Car("pobi");
        assertEquals("pobi : ", testCar.printStatus());
        testCar.moveForward();
        assertEquals("pobi : -", testCar.printStatus());
    }
}
