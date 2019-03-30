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

    @Test
    public void raceTest(){
        Car[] garage = config.makeGarage(new String[] {"Tommi","Pride","Cago"});
        for(int i=0; i<5; i++) {
            config.race(garage);
        }
        System.out.println("Tommi : "+garage[0].getPosition());
        System.out.println("Pride : "+garage[1].getPosition());
        System.out.println("Cago : "+garage[2].getPosition());
    }

    @Test
    public void printWinnerTest(){
        Car[] garage = config.makeGarage(new String[] {"Tommi","Pride","Cago"});
        garage[0].movePosition();
        String result = config.printWinner(garage);
        assertEquals("Tommi",result);
        garage[2].movePosition();
        String anotherResult = config.printWinner(garage);
        assertEquals("Tommi,Cago",anotherResult);
        garage[1].movePosition();
        String otherResult = config.printWinner(garage);
        assertEquals("Tommi,Pride,Cago",otherResult);
    }

    @After
    public void setEnd() {
        System.out.println("setEnd");
    }
}
