package domain.validator;

public class MoveNumValidator implements Validator {

    private final int moveNum;

    private MoveNumValidator(int moveNum) {
        this.moveNum = moveNum;
    }

    public static MoveNumValidator createMoveNumValidatorWithMoveNum(int moveNum) {
        return new MoveNumValidator(moveNum);
    }

    @Override
    public boolean doesValid() {
        return doesMoveNumIsPositiveInteger(moveNum);
    }

    public boolean doesMoveNumIsPositiveInteger(int moveNum) {
        return moveNum > 0;
    }
}
