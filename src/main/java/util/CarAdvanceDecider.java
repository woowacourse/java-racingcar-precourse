package util;

import java.util.Random;

/**
 * 자동차가 전진할지 후진할지 결정한다.
 * @author delf
 */
public class CarAdvanceDecider {
    private final static Random random = new Random();

    public boolean getTrueOrFalseByChance(int trueRatio, int falseRatio) {
        int gcd = getGcd(trueRatio, falseRatio);
        return random.nextInt((trueRatio + falseRatio) / gcd) > trueRatio;
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
