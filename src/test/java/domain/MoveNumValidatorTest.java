package domain;

import domain.validator.MoveNumValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveNumValidatorTest {

    @Test
    public void testFailToValidateMoveNumIfNumIsNegative() throws AssertionError {
        MoveNumValidator moveNumValidator = MoveNumValidator.createMoveNumValidatorWithMoveNum(-1);

        assertFalse(moveNumValidator.doesMoveNumIsPositiveInteger(-1));
    }
}