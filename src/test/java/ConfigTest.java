import domain.Car;
import domain.Config;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigTest {
    private Config config;

    @Before
    public void setup() {
        config = new Config();
    }


    @Test
    public void splitName() {
        String[] result = config.splitName("Tommi,Pride,Cago");
        assertEquals(new String[]{"Tommi", "Pride", "Cago"}, result);
    }

    @Test
    public void checkNameNumber() {
        String[] nameArrayTrue = config.splitName("Tommi,Pride,Cago");
        Boolean resultTrue = config.checkNameNumber(nameArrayTrue);
        String[] nameArrayFalse = config.splitName("Tommi,Pride,Genesis");
        Boolean resultFalse = config.checkNameNumber(nameArrayFalse);
        assertEquals(resultTrue, Boolean.TRUE);
        assertEquals(resultFalse, Boolean.FALSE);
    }


    @After
    public void setEnd() {
        System.out.println("setEnd");
    }
}
