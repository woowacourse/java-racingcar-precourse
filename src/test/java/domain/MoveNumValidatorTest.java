package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoveNumValidatorTest {

    @Test
    public void testFailToValidateMoveNumIfNumIsNegative() throws AssertionError {
        MoveNumValidator moveNumValidator = new MoveNumValidator("-1");

        assertFalse(moveNumValidator.doesMoveNumIsPositiveInteger(-1));
    }
}