package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveTicket {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int THRESHOLD = 4;

    final private Integer ticketValue;

    private MoveTicket() {
        this.ticketValue = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

    public static MoveTicket publish() {
        return new MoveTicket();
    }

    public boolean isValidTicket() {
        return this.ticketValue >= THRESHOLD;
    }
}
