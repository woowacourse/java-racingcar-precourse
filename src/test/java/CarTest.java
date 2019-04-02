import junit.framework.TestCase;
import org.junit.Test;
import domain.Car;
public class CarTest extends TestCase {

    @Test
    public void testMoveForward() throws Exception {
        /* testMoveForward 는 자동차의 전진 기능을 테스트합니다. */
        Car testCar = new Car("test");
        Car.moveForward();
        assertEquals(Car.position, 1);
    }
}
