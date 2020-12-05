package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {

    /*
     * 랜덤숫자를 반환하는 총 횟수를 10으로 봤을 때 0 ~ 9까지의 각 숫자가 0.85 ~ 1.15 안으로 나올 경우 비슷한 빈도라고 가정하고 테스트를 짬.
     * 처음에는 0.9 ~ 1.1로 했으나, 1000번 이상 시도할 경우 테스트가 실패하는 경우가 많았음.
     * 0.85 ~ 1.15로 구간을 늘리자 10만번 이상 시도할 경우 테스트가 실패하는 경우가 생기기도 함.
     */
    @DisplayName("0~9까지의 랜덤숫자를 구했을 때 같은 빈도로 값이 나오는지 확인")
    @Test
    void nextInt() {
        int testTrial = 100;
        int sampleTrial = 10000;
        int sampleSize = 10;

        List<int[]> randomArrays = makeRandomArrays(testTrial,sampleTrial,sampleSize);

        assertThat(isConfidenceInterval(randomArrays, sampleTrial, sampleSize)).isTrue();
    }

    private boolean isConfidenceInterval(List<int[]> randomArrays, int trial, int sampleSize){
        for (int[] randomArray : randomArrays) {
            if (!isConfidenceInterval(randomArray, trial, sampleSize)) {
                return false;
            }
        }
        return true;
    }

    private boolean isConfidenceInterval(int[] randomArray, int trial, int sampleSize) {
        double expectedValue = (double) trial / sampleSize;
        for (int i : randomArray) {
            // 기댓값의 85% 이하 이거나, 115% 이상일 경우 false 반환.
            if (i < 0.85 * expectedValue || i > 1.15 * expectedValue) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    private int[] makeRandomArray(int trial, int sampleSize) {
        int[] numberArray = new int[sampleSize];
        Arrays.fill(numberArray, 0);

        for (int i = 0; i < trial; i++) {
            numberArray[RandomUtils.nextInt(0, sampleSize - 1)]++;
        }
        return numberArray;
    }

    private List<int[]> makeRandomArrays(int testTrial, int sampleTrial, int sampleSize) {
        List<int[]> randomArrays = new ArrayList<>();
        for (int i = 0; i < testTrial; i++) {
            randomArrays.add(makeRandomArray(sampleTrial, sampleSize));
        }
        return randomArrays;
    }
}