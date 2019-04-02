import domain.Car;
import domain.Config;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class ConfigTest {
    private Config config;

    @Before
    public void setup() {
        config = new Config();
    }


    @Test
    public void makeArrayByStringTest() {
        String[] result = config.makeArrayByString("Tommi,Pride,Cago");
        assertEquals(new String[]{"Tommi", "Pride", "Cago"}, result);
    }

    @Test
    public void checkNameNumberTest() {
        String[] nameArrayTrue = config.makeArrayByString("Tommi,Pride,Cago");
        Boolean resultTrue = config.checkNameNumber(nameArrayTrue);
        String[] nameArrayFalse = config.makeArrayByString("Tommi,Pride,Genesis");
        Boolean resultFalse = config.checkNameNumber(nameArrayFalse);
        String[] nameArrayFalseSpace = config.makeArrayByString(" Tommi ,Pride,Cago");
        Boolean resultFalseSpace = config.checkNameNumber(nameArrayFalseSpace);
        assertEquals(resultTrue, Boolean.TRUE);
        assertEquals(resultFalse, Boolean.FALSE);
        assertEquals(resultFalseSpace, Boolean.FALSE);
    }

    @Test
    public void makeGarageTest() {
        Car[] garage = config.makeGarage(new String[]{"Tommi", "Pride", "Cago"});
        String Tommi = garage[0].getName();
        String Pride = garage[1].getName();
        String Cago = garage[2].getName();
        assertEquals("Tommi", Tommi);
        assertEquals("Pride", Pride);
        assertEquals("Cago", Cago);
    }

    @Test
    public void makeRandomTest() {
        int randomNumber = config.makeRandom();
        String randomString = String.valueOf(randomNumber);
        String resultCheck = "^[0-9]{1}$";
        boolean resultTrue = Pattern.matches(resultCheck, randomString);
        boolean resultFalse = Pattern.matches(resultCheck, "10");
        assertEquals(true, resultTrue);
        assertEquals(false, resultFalse);
    }

    @Test
    public void raceTest() {
        Car[] garage = config.makeGarage(new String[]{"Tommi", "Pride", "Cago"});
        for (int i = 0; i < 5; i++) {
            config.race(garage);
        }
    }

    @Test
    public void printWinnerTest() {
        Car[] garage = config.makeGarage(new String[]{"Tommi", "Pride", "Cago"});
        garage[0].movePosition();
        String result = config.printWinner(garage);
        assertEquals("Tommi", result);
        garage[2].movePosition();
        String anotherResult = config.printWinner(garage);
        assertEquals("Tommi,Cago", anotherResult);
        garage[1].movePosition();
        String otherResult = config.printWinner(garage);
        assertEquals("Tommi,Pride,Cago", otherResult);
    }

    @Test
    public void characterMultipleTest() {
        String result = config.characterMultiple('-', 5);
        assertEquals("-----", result);
    }


    @After
    public void setEnd() {
        System.out.println("setEnd");
    }
}
