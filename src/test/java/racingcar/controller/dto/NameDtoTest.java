package racingcar.controller.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameDtoTest {

    @DisplayName("쉼표를 구분자로 이름을 분리한다.")
    @Test
    void buildWithName() {
        String carName = "car, name, is, split, comma";

        NameDto dto = NameDto.builder()
                .names(carName)
                .build();

        assertThat(dto.getNames()).containsExactly(carName.split(", "));
    }

}
