import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import utils.GameUtils;

import java.util.Scanner;

public class GameUtilsTest {
    private static Scanner rightCarName;
    private static Scanner wrongCarName;

    @BeforeAll
    public static void setUp() {
        rightCarName = new Scanner("pobi");
        wrongCarName = new Scanner("itsoverfive");
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
}
