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
            System.out.println();
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
        do {
            String line = br.readLine();
            try {
                this.cars = parseInputAsCars(line);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (this.cars.isEmpty());
    }

    private List<Car> parseInputAsCars(String line) throws IllegalArgumentException {
        List<String> names = Arrays.asList(line.split(","));
        long commaCount = line.chars().filter(i -> i == (int) ',').count();
        List<Car> cars = names.stream().map(Car::new).collect(Collectors.toList());
        // 콤마기준으로 이름을 분리하므로 매 콤마문자마다 하나의 이름이 생성되어야 하고,
        // 마지막콤마 이후 이름영역이 하나더 존재하므로 최종 List<Car>의 크기는 콤마문자 개수 + 1 이 되어야 한다.
        if (commaCount + 1 == cars.size()) {
            return cars;
        }
        throw new IllegalArgumentException("잘못된 형식의 이름목록 입력입니다.");
    }

    private void doOneSimulationTurn() {
        final int CAR_NAME_FORMAT_WIDTH = 1;
        this.cars.forEach(Car::move);
        this.cars.forEach(car -> System.out.println(car.format(CAR_NAME_FORMAT_WIDTH)));
    }

    /**
     * 우승 Car 목록 추출방법: 각 {@code Car} 의 {@code position} 필드값을 기준으로 내림차순 정렬하여
     * 가장 빠른 것들 중의 하나일 첫번째 원소를 {@code List<Car>} 에서 고릅니다.
     * 골라진 원소와 {@code position} 값이 일치하는 것들을 {@code List<Car>}에서 {@code filter}를 이용하여 추출합니다.
     */
    private void displayWinnerCars() {
        Car aFastestCar = this.cars
            .stream()
            .sorted()
            .collect(Collectors.toList())
            .get(0);
        String winnerCars = this.cars
            .stream()
            .filter(car -> car.equals(aFastestCar))
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(winnerCars + "가 최종 우승 했습니다.");
    }
}
