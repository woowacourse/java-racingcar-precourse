import junit.framework.TestCase;
import org.junit.Test;
import domain.Car;
import domain.MainApp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainAppTest extends TestCase {
    /* 메인프로그램의 자동차 이름을 받는 기능을 테스트합니다. */
    @Test
    public void testGetCarNames() throws Exception {
        String testCarNames[] = {"pobi", "crong", "honux"};                    // 정답으로 사용될 자동차 이름들입니다.
        String testInput = "pobi,crong,honux";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());       // 사용자 입력을 모방하는 트릭입니다.
        System.setIn(in);
        String inputCarNames[] = MainApp.getCarNames();
        for (int i = 0; i < testCarNames.length; i++) {
            assertEquals(testCarNames[i], inputCarNames[i]);
        }
        System.setIn(System.in);                                               // 입력을 원래대로 돌려 놓습니다.
    }

    /* 메인 프로그램의 자동차 배열을 만드는 기능을 테스트합니다. */
    @Test
    public void testCreateArrayOfCars() throws Exception {
        String testCarNames[] = {"pobi", "crong", "honux"};
        Car testCars[] = MainApp.createArrayOfCars(testCarNames);
        for (int i = 0; i < testCarNames.length; i++) {
            assertEquals(testCarNames[i], testCars[i].getName());
        }
    }

    /* 메인 프로그램이 사용자로부터 경주 시도 횟수를 입력받는 기능을 테스트합니다. */
    @Test
    public void testGetNumOfTrials() throws Exception {
        int numOfTrials;

        String testInput = "5";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        numOfTrials = MainApp.getNumOfTrials();
        assertEquals(5, numOfTrials);
        System.setIn(System.in);
    }

    /* 메인 프로그램이 확률적으로 자동차를 전진 혹은 멈추게 하는 기능을 테스트합니다. */
    @Test
    public void testRandomlyMoveCar() throws Exception {
        Car testCar = new Car("pobi");

        int randomNumber = MainApp.randomlyMoveCar(testCar);
        if (randomNumber < 4 && randomNumber >= 0) {
            assertEquals(0, testCar.getPosition());
            return;
        }
        if (randomNumber >= 4 && randomNumber <= 9) {
            assertEquals(1, testCar.getPosition());
            return;
        }
        fail();                                                                 // randomNumber 는 반드시 0 ~ 9 사이의 값이어야 합니다.
    }

    /* 메인 프로그램이 우승자를 가려내는 기능을 테스트합니다. */
    @Test
    public void testGetWinners() throws Exception {
        Car testCars[] = new Car[3];
        testCars[0] = new Car("pobi");
        testCars[1] = new Car("crong");
        testCars[2] = new Car("honux");

        testCars[0].moveForward();
        testCars[0].moveForward();
        testCars[1].moveForward();
        testCars[2].moveForward();
        testCars[2].moveForward();

        String winnerNames = MainApp.getWinners(testCars);
        assertEquals("pobi, honux", winnerNames);
    }
}
