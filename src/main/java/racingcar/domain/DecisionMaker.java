/**
 * DecisionMaker.java
 * 자동차에게 전진 여부를 판단해주는 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */

package racingcar.domain;

import utils.RandomUtils;

public class DecisionMaker {
    private static final int MIN_INCLUSIVE = 0;
    private static final int MAX_INCLUSIVE = 9;
    private static final int THRESHOLD = 4;

    public static boolean makeDecision() {
        int randomNumber = RandomUtils.nextInt(MIN_INCLUSIVE, MAX_INCLUSIVE);
        if (THRESHOLD <= randomNumber) {
            return true;
        }
        return false;
    }
}
