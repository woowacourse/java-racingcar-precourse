import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import utils.GameUtils;

import java.util.Scanner;

public class GameUtilsTest {
    private static Scanner rightCarName;
    private static Scanner wrongCarName;
    private static Scanner blankCarName;
    private static Scanner rightNumOfRuns;
    private static Scanner wrongNumOfRuns;

    @BeforeAll
    public static void setUp() {
        rightCarName = new Scanner("pobi");
        wrongCarName = new Scanner("itsoverfive");
        rightNumOfRuns = new Scanner("5");
        wrongNumOfRuns = new Scanner("다섯번");
    }

    @AfterAll
    public static void tearDown() {
        rightCarName.close();
        wrongCarName.close();
        rightNumOfRuns.close();
        wrongNumOfRuns.close();
    }

    @Test
    public void carNameRightTest() {
        String carName = rightCarName.next();
        GameUtils.isCarNameRight(carName);
    }

    @Test
    public void carNameWrongTest() {
        String carName = wrongCarName.next();

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {GameUtils.isCarNameRight(carName);})
                .withMessage("[ERROR] 차 이름은 5글자 이하여야 한다.");
    }

    @Test
    public void carNameBlankTest() {
        String carName = "";

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {GameUtils.isCarNameRight(carName);})
                .withMessage("[ERROR] 차 이름은 1글자 이상이어야 한다.");
    }

    @Test
    public void numOfRunsRightTest() {
        String num = rightNumOfRuns.next();
        GameUtils.isCarNameRight(num);
    }

    @Test
    public void numOfRunsWrongTest() {
        String num = wrongNumOfRuns.next();

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {GameUtils.isNumOfRunsRight(num);})
                .withMessage("[ERROR] 시도 횟수는 숫자여야 한다.");
    }
}
