package util;

import java.util.Random;

/**
 * 자동차가 전진할지 후진할지 결정한다.
 *
 * @author delf
 */
public class CarAdvanceDecider {
    private final static Random random = new Random();

    public boolean getTrueOrFalseByChance(int trueRatio, int falseRatio) {
        /* 요구사항에서는 전진과 정지에 지정된 숫자가 존재하지만, 단순하게 확률만 생각한다. */
        int gcd = getGcd(trueRatio, falseRatio);
        int r = random.nextInt((trueRatio + falseRatio) / gcd);
        return r < (trueRatio / gcd);
    }

    private int getGcd(int u, int v) {
        int t;
        while (v > 0) {
            t = u % v;
            u = v;
            v = t;
        }
        return u;
    }
}
