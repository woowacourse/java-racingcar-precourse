package domain;

import racingcar.Game;
import utils.Validation;
import view.InputView;

public class Turn {
    private int turns;
    private Validation validation = new Validation();

    public Turn(String turns){
        try {
            validation.timesValidate(turns);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.turns = Integer.valueOf(turns);
    }

    public int getTurns(){
        return this.turns;
    }
}
