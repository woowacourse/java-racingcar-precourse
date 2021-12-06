package service;

import camp.nextstep.edu.missionutils.Randoms;
public class OneDigitNumberGenerator implements RandomNumberGenerator {

    @Override
    public int generateRandomNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
