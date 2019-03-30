import domain.Car;
import domain.Config;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Car car;
    private Config config;

    @Before
    public void setup(){
        car = new Car("Tommi");
        config = new Config();
    }

    @Test
    public void getNameTest(){
        String result = car.getName();
        assertEquals(new String("Tommi"), result);
    }

    @Test
    public void splitName(){
        String[] result = config.splitName("Tommi,Pride,Cago");
        assertEquals(new String[]{"Tommi","Pride","Cago"},result);
    }

    @After
    public void setEnd(){
        System.out.println("setEnd");
    }
}
