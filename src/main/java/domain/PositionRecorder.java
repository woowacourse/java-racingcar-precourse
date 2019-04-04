package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class PositionRecorder {
    private HashMap<String, HashMap> leagueHIstories;
    private HashMap<Integer, HashMap> trialHistories;
    private HashMap<String, Integer> carPositions = new HashMap<String, Integer>();

    public void detectPositionsOf(ArrayList<Car> cars) {
        for (Car car: cars) {
            carPositions.put(car.getName(), car.getPosition());
        }
    }

    public void recordHistoryOf(String leagueName, int trial, ArrayList<Car> cars) {

    }

    public String repeat(String str, int repeatTime) {
        StringBuffer repeated = new StringBuffer();

        for (int i = 0; i < repeatTime; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }

    public void showHistoryOf(String leagueName) {

    }

    public void showPositions() {
        for (String carName: carPositions.keySet()) {
            System.out.print(carName + " : ");
            System.out.println(repeat("-", carPositions.get(carName)));
        }
        System.out.print("\n");
    }

    public String pickWinners() {
        int maxPosition = -1;
        StringBuffer winners = new StringBuffer();

        for (String carName: carPositions.keySet()) {
            if (carPositions.get(carName) > maxPosition) {
                winners = new StringBuffer().append(carName);
                maxPosition = carPositions.get(carName);
            } else if (carPositions.get(carName) == maxPosition) {
                winners.append(", " + carName);
            }
        }
        return winners.toString();
    }

    public void showWinners() {
        String winners = pickWinners();

        System.out.println(winners + "(이)가 최종 우승했습니다.");
    }
}