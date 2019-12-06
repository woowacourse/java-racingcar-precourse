package domain;

import java.util.*;

public class RandomMakeNum {
    Random randomInput = new Random();

    public boolean randomMakeNum() {
        int input = 0;

        input = randomInput.nextInt(9) + 1;
        if (input < 4) {
            return false;
        }
        return true;
    }
}
