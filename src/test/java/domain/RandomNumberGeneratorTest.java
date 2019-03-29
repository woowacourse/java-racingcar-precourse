package domain;

import domain.interfaces.NumberGenerator;
import org.junit.Assert;
import org.junit.Test;

public class RandomNumberGeneratorTest {
    private static final int TEST_LOOP_COUNT = 100;

    private NumberGenerator generator = new RandomNumberGenerator();

    @Test
    public void testNumberGeneration() {
        boolean lowerBoundPresence = false;
        boolean upperBoundPresence = false;
        for (int i = 0; i < TEST_LOOP_COUNT; i++) {
            int n = generator.getNumber();
            Assert.assertTrue(n >= NumberGenerator.MIN && n <= NumberGenerator.MAX);
            if (n == NumberGenerator.MIN) {
                lowerBoundPresence = true;
            }
            if (n == NumberGenerator.MAX) {
                upperBoundPresence = true;
            }
        }
        Assert.assertTrue(lowerBoundPresence);
        Assert.assertTrue(upperBoundPresence);
    }
}
