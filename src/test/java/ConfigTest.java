import domain.Car;
import domain.Config;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class ConfigTest {
    private Config config;

    @Before
    public void setup() {
        config = new Config();
    }


    @Test
    public void splitNameTest() {
        String[] result = config.splitName("Tommi,Pride,Cago");
        assertEquals(new String[]{"Tommi", "Pride", "Cago"}, result);
    }

    @Test
    public void checkNameNumberTest() {
        String[] nameArrayTrue = config.splitName("Tommi,Pride,Cago");
        Boolean resultTrue = config.checkNameNumber(nameArrayTrue);
        String[] nameArrayFalse = config.splitName("Tommi,Pride,Genesis");
        Boolean resultFalse = config.checkNameNumber(nameArrayFalse);
        assertEquals(resultTrue, Boolean.TRUE);
        assertEquals(resultFalse, Boolean.FALSE);
    }

    @Test
    public void makeGarageTest(){
        Car[] garage = config.makeGarage(new String[] {"Tommi","Pride","Cago"});
        String Tommi = garage[0].getName();
        String Pride = garage[1].getName();
        String Cago = garage[2].getName();
        assertEquals("Tommi",Tommi);
        assertEquals("Pride",Pride);
        assertEquals("Cago",Cago);
    }

    @Test
    public void makeRandomTest(){
        int randomNumber = config.makeRandom();
        String randomString = String.valueOf(randomNumber);
        String resultCheck  = "^[0-9]{1}$";
        boolean resultTrue = Pattern.matches(resultCheck,randomString);
        boolean resultFalse = Pattern.matches(resultCheck,"10");
        assertEquals(true,resultTrue);
        assertEquals(false,resultFalse);
    }

    @After
    public void setEnd() {
        System.out.println("setEnd");
    }
}
