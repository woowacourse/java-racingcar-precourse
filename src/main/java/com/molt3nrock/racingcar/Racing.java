package com.molt3nrock.racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Racing {

    private static final int VALID_MIN_SIMULATION_TIMES = 0;
    private List<Car> cars = new ArrayList<>();
    private int simulationTimes = VALID_MIN_SIMULATION_TIMES - 1;

    public static void main(String[] args) throws IOException {
        Racing racing = new Racing();
        racing.setSimulationTimes();
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
}
