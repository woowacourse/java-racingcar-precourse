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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    public void registerCars() {
        setupMockInputStream("a,123456,c\na,ab,abc,1234,,12345\n");
        callMethod(racing, "registerCars");
        List<Car> cars = getListField(racing, "cars");
        assertEquals(6, cars.size());
        List<String> outputList = Arrays.asList("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                                                "Car: 123456은 너무 깁니다. 5자이내로 입력해주세요.");
        String expected = outputList.stream().map(s -> s + "\n").reduce("", (a, b) -> a + b);
        assertEquals(expected, bo.toString());
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
        String expected = outputList.stream().map(s -> s + "\n").reduce("", (a, b) -> a + b);
        assertEquals(expected, bo.toString());
    }

    @Test
    public void displayWinnerCars() {
        int maxTestCars = 12;
        setupMockInputStream("");
        List<Car> cars = IntStream.range(0, maxTestCars - 2)
            .mapToObj(i -> new Car(Integer.toString(i)))
            .collect(Collectors.toList());
        IntStream.range(0, cars.size()).forEach(i -> setIntField(cars.get(i), "position", i));
        cars.add(setIntField(new Car("fast"), "position", maxTestCars));
        cars.add(setIntField(new Car("fast"), "position", maxTestCars));
        Collections.shuffle(cars);
        setListField(racing, "cars", cars);
        callMethod(racing, "displayWinnerCars");
        assertEquals("fast, fast가 최종 우승 했습니다.\n", bo.toString());
    }

    private void setupMockInputStream(String line) {
        ByteArrayInputStream bi = new ByteArrayInputStream(line.getBytes());
        bo = new ByteArrayOutputStream();
        System.setIn(bi);
        System.setOut(new PrintStream(bo));
    }

    private Car setIntField(Car car, String fieldName, int position) {
        try {
            Field f = car.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(car, position);
            return car;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
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

    private List<Car> getListField(Racing racing, String fieldName) {
        try {
            Field f = racing.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            return (ArrayList<Car>) f.get(racing);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void setListField(Racing racing, String fieldName, List<Car> cars) {
        try {
            Field f = racing.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(racing, cars);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
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