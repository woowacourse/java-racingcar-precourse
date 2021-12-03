package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    void 이름_입력() {
        assertThat(validateName(splitName("pobi,woni,jun,inchan,wootech,")))
                .startsWith("[ERROR]")
                .contains("[ERROR]");

//        assertThatThrownBy(() -> {
//            validateName(splitName("pobi,woni,jun,inchan,wootech,"));
//        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_입력_성공() {
        assertThat(validateCount("5"))
                .contains("true");
    }

    @Test
    void 횟수_입력_예외() {
        assertThat(validateCount("다섯번"))
                .startsWith("[ERROR]")
                .contains("[ERROR]");
        
        assertThat(validateCount(""))
                .startsWith("[ERROR]")
                .contains("[ERROR]");
    }

    public String validateCount(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            return "[ERROR] 시도 횟수는 숫자여야 한다.";
        }
        return "true";
    }

    public String validateName(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
//                throw new IllegalArgumentException();
                return "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
            }
            if (name.length() == 0) {
//                throw new IllegalArgumentException();
                return "[ERROR] 자동차 이름은 빈 문자열일 수 없습니다.";
            }
        }
        return "true";
    }

    public String[] splitName(String nameString) {
        return nameString.split(",");
    }
}
