/**
 * Turn.java
 * 게임의 회차를 담당하는 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */

package racingcar.domain;

public class Turn {
    private final int endTurn;
    private int currentTurn;

    private Turn(int endTurn) {
        this.endTurn = endTurn;
        this.currentTurn = 0;
    }

    public static Turn from(int endTurn) {
        isValidValueOrThrowException(endTurn);
        return new Turn(endTurn);
    }

    public static boolean isValidValueOrThrowException(int endTurn) {
        if (endTurn <= 0) {
            throw new IllegalArgumentException("회수는 양의 정수만 가능합니다.");
        }
        return true;
    }

    public void turnOver() {
        this.currentTurn++;
    }

    public boolean isEnd() {
        return this.endTurn <= this.currentTurn;
    }
}
