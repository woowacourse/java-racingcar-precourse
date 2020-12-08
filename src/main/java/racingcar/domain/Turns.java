package racingcar.domain;

import racingcar.view.ErrorViewer;

public class Turns {
    private static final int ZERO_NUMBER = 0;

    private int nowTurn = 0;
    private int finalTurn;

    public Turns(String primitiveNumber) {
        int number = translateInteger(primitiveNumber);
        checkPositiveNumber(number);
        this.finalTurn = number;
    }

    private int translateInteger(String primitiveNumber) {
        try {
            return Integer.parseInt(primitiveNumber);
        } catch (Exception e) {
            ErrorViewer.showIntegerInputError();
            return Integer.parseInt(primitiveNumber);
        }
    }

    private void checkPositiveNumber(int primitiveNumber) {
        if (primitiveNumber <= ZERO_NUMBER) {
            ErrorViewer.showNotPositiveInputError();
        }
    }

    public void processTurn() {
        this.nowTurn++;
    }

    public boolean isEndTurns() {
        if (nowTurn >= finalTurn) {
            return true;
        }
        return false;
    }
}
