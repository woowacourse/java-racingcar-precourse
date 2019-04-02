import domain.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {
    private Car car;


    @Before
    public void setup() {
        car = new Car("Tommi");
    }

    @Test
    public void getNameTest() {
        String result = car.getName();
        assertEquals(new String("Tommi"), result);
    }

    @Test
    public void getPosition() {
        int result = car.getPosition();
        assertEquals(0, result);
    }

    @Test
    public void movePosition() {
        int result = car.movePosition();
        assertEquals(1, result);
    }


    @After
    public void setEnd() {
        System.out.println("setEnd");
    }
}
