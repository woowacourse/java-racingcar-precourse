package domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class RacingStadiumTest {

    @Test
    void getReady() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int nameCount = 5;
        String[] carNames = new String[nameCount];
        makeCarNames(nameCount, carNames);

        RacingStadium racingStadium = new RacingStadium(carNames, 3);
        Method method = racingStadium.getClass().getDeclaredMethod("getReady", String[].class);
        method.setAccessible(true);
        Car[] result = (Car[]) method.invoke(racingStadium, (Object) carNames);

        for (int i = 0; i < nameCount; i++) {
            assertEquals(carNames[i], result[i].getName());
        }
    }

    private void makeCarNames(int nameCount, String[] carNames) {
        for (int i = 0; i < nameCount; i++) {
            carNames[i] = Character.toString((char) (i + 65));
        }
    }
}