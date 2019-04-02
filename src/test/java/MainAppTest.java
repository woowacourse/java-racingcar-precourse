import junit.framework.TestCase;
import org.junit.Test;
import domain.Car;
import domain.MainApp;

public class MainAppTest extends TestCase {
    /* 메인프로그램의 자동차 이름을 받는 기능을 테스트합니다. */
    @Test
    public void testGetCarNames() throws Exception {
        String testCarNames[] = {"pobi", "crong", "honux"};  // 정답에 사용될 자동차 이름들입니다.
        String inputCarNames[] = MainApp.getCarNames();  // "pobi,crong,honux" 를 사용자가 입력해야합니다.
        for (int i=0; i<testCarNames.length; i++) {
            assertEquals(testCarNames[i], inputCarNames[i]);
        }
    }
}
