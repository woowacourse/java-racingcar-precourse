package com.molt3nrock.racingcar;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class RacingTest {

    private Racing racing;
    private ByteArrayOutputStream bo;

    @Before
    public void setUp() {
        racing = new Racing();
    }

    @Test
    public void setSimulationTimes() {
        setupMockInputStream("-10\nabc\n42\n");
        callMethod(racing, "setSimulationTimes");
        int simulationTimes = getIntField(racing, "simulationTimes");
        assertEquals(42, simulationTimes);
        List<String> outputList = Arrays.asList("시도할 회수는 몇회인가요?",
                                                "잘못된 시도 휫수 입력입니다: -10",
                                                "잘못된 시도 휫수 입력입니다: abc");
        String expected = outputList.stream().map(s -> s + "\n").reduce("", (a,b) -> a + b);
        assertEquals(expected, bo.toString());
    }

    private void setupMockInputStream(String line) {
        ByteArrayInputStream bi = new ByteArrayInputStream(line.getBytes());
        bo = new ByteArrayOutputStream();
        System.setIn(bi);
        System.setOut(new PrintStream(bo));
    }

    private int getIntField(Racing racing, String fieldName) {
        try {
            Field f = racing.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            return (int) f.get(racing);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void callMethod(Racing racing, String methodName) {
        try {
            Method m = racing.getClass().getDeclaredMethod(methodName, (Class<?>[]) null);
            m.setAccessible(true);
            m.invoke(racing, (Object[]) null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}