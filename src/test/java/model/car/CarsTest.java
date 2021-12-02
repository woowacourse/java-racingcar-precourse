package model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {
    @Test
    @DisplayName("자동차들의 이름들 간에 중복이 있으면 예외를 발생시킨다.")
    void evokeExceptionByOverlappedNames() {
        List<String> overlappedNames = Arrays.asList("Chris", "Chris", "Henry");
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(overlappedNames))
                .withMessage("이름들 간에 중복이 있습니다.");
    }

}