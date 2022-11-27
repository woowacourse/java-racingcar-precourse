package code;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.lhg.codechecker.tool.CodeChecker;

public class CodeTest {

    @Test
    void parameterTest() {
        // given
        CodeChecker codeChecker = CodeChecker.rules()
                .limitParameters(3)
                .build();

        // when
        boolean check = codeChecker.checkParameterCount("racingcar", true);

        // then
        System.out.println(codeChecker.getMessage());
        assertThat(check).isEqualTo(true);
    }
}
