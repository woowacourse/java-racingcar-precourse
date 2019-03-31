package domain;

public class MoveNumValidator implements Validator {

    private final String moveNumString;

    public MoveNumValidator(String moveNumString) {
        this.moveNumString = moveNumString;
    }

    @Override
    public boolean doesValid() {
        return doesMoveNumIsPositiveInteger(Integer.parseInt(moveNumString));
    }

    public boolean doesMoveNumIsPositiveInteger(int moveNum) {
        return moveNum > 0;
    }
}
