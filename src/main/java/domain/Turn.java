package domain;

import utils.Validation;


public class Turn {
    private int turns;
    private Validation validation = new Validation();

    public Turn(String turns) {
        try {
            validation.turnsValidate(turns);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.turns = Integer.valueOf(turns);
    }

    public int getTurns() {
        return this.turns;
    }
}
