package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomNumGeneratorTest {

    @Test
    public void testFailToGenerateValidRandomNumIfRandomNumBelowLowerBound() throws AssertionError {
        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

        int random = randomNumGenerator.generateRandomNum();

        assertFalse(random < RandomNumGenerator.RandomNumBound.LOWER.getBound());
    }

    @Test
    public void testFailToGenerateValidRandomNumIfRandomNumAboveUpperBound() throws AssertionError {
        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

        int random = randomNumGenerator.generateRandomNum();

        assertFalse(random > RandomNumGenerator.RandomNumBound.UPPER.getBound());
    }
}