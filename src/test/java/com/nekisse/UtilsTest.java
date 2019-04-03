package com.nekisse;

import com.nekisse.domain.CarName;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void 자동차_이름_쉼표구분_후_리스트로_변환() {
        String input = "abcc,der,가,나";
        List<CarName> carNames = Utils.parseStringToGetCarNames(input);
        assertThat(carNames.size()).isEqualTo(4);
        assertThat(carNames.get(0).getCarName()).isEqualTo("abcc");
    }
}