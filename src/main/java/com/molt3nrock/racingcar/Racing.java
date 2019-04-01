package com.molt3nrock.racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private static final int VALID_MIN_SIMULATION_TIMES = 0;
    private List<Car> cars = new ArrayList<>();
    private int simulationTimes = VALID_MIN_SIMULATION_TIMES - 1;

    public static void main(String[] args) throws IOException {
        Racing racing = new Racing();
        racing.registerCars();
        racing.setSimulationTimes();
        System.out.println("\n실행 결과");
        for (int i = 0; i < racing.simulationTimes; i++) {
            racing.doOneSimulationTurn();
            System.out.println("\n");
        }
        racing.displayWinnerCars();
    }

    private void setSimulationTimes() throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            try {
                this.simulationTimes = Integer.parseInt(line);
            } catch (NumberFormatException ignored) {
            }
            if (simulationTimes >= VALID_MIN_SIMULATION_TIMES) {
                break;
            }
            System.out.println(String.format("잘못된 시도 휫수 입력입니다: %s", line));
        }
    }

    private void registerCars() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            List<Car> cars = parseInputAsCars(line);
            if (!cars.isEmpty()) {
                this.cars = cars;
                break;
            }
        }
    }

    private List<Car> parseInputAsCars(String line) {
        String[] foo = line.split(",");
        List<String> names = Arrays.asList(foo);
        long commaCount = line.chars().filter(i -> i == (int) ',').count();
        try {
            List<Car> cars = names.stream().map(Car::new).collect(Collectors.toList());
            if (commaCount + 1 == cars.size()) {
                return cars;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    private void doOneSimulationTurn() {
        this.cars.forEach(Car::move);
        this.cars.forEach(System.out::println);
    }

    private void displayWinnerCars() {
        // Car 의 position 을 기준으로 내림차순 정렬 하여 가장빠른 Car 를 추출
        Car aFastestCar = this.cars
            .stream()
            .sorted()
            .collect(Collectors.toList())
            .get(0);
        // 앞서 추출한 Car 와 위치가 같은 Car 들을 출력
        String winnerCars = this.cars
            .stream()
            .filter(car -> car.equals(aFastestCar))
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(winnerCars + "가 최종 우승 했습니다.");
    }
}
