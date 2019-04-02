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
        for (int i=0; i<testCarNames.length; i++) {
            assertEquals(testCarNames[i], inputCarNames[i]);
        }
        System.setIn(System.in);                                               // 입력을 원래대로 돌려 놓습니다.
    }
}
