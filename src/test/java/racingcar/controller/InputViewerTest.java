package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewerTest {
    private static final int MAX_FLAG_NUMBER = 9;
    private static final int MIN_FLAG_NUMBER = 0;

    private InputViewer inputViewer;

    @BeforeEach
    void beforeEachTest() {
        this.inputViewer = new InputViewer(new Scanner(System.in));
    }

    @Test
    void 숫자범위_내부_0_에서_9_사이의_숫자_리스트_반환() {
        // given
        final int numberOfElement = 3;

        // when
        List<Integer> movingNumberFlagList = this.inputViewer.makeRandomZeroToNineBoundedNumberList(numberOfElement);

        // then
        for (int eachFlag : movingNumberFlagList) {
            assertThat(MIN_FLAG_NUMBER <= eachFlag && eachFlag <= MAX_FLAG_NUMBER).isTrue();
        }
    }
}