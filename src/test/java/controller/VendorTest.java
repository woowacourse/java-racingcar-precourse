package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendorTest {

    @Test
    void roll() {

        for (int i = 0; i < 100000; i++) {
            int roll = Vendor.roll();
            assertTrue(roll != -1 && roll != 10);
        }

    }
}