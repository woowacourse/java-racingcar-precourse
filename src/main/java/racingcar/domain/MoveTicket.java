package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveTicket {

    final private static int MIN_VALUE = 0;
    final private static int MAX_VALUE = 9;
    final private static int THRESHOLD = 4;

    private final Integer ticketValue;

    public static boolean checkTicket() {
        return new MoveTicket().isValidTicket();
    }

    private MoveTicket() {
        this.ticketValue = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

    private boolean isValidTicket() {
        return this.ticketValue >= THRESHOLD;
    }
}
