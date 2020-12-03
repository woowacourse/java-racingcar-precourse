package controller;

import utils.RandomUtils;

public class Vendor {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private Vendor() {
    }

    public static int roll() {
        return RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
    }
}