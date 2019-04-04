package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PositionRecorder {
    private LeagueHistoryDB leagueHistories = new LeagueHistoryDB();

    public HashMap<String, Integer> detectPositionsOf(ArrayList<Car> cars) {
        HashMap<String, Integer> carPositions = new HashMap<String, Integer>();

        for (Car car: cars) {
            carPositions.put(car.getName(), car.getPosition());
        }
        return carPositions;
    }

    public void recordPositionsOf(String leagueName, int trial, ArrayList<Car> cars) {
        leagueHistories.writeHIstory(leagueName, trial, detectPositionsOf(cars));
    }

    public String repeat(String str, int repeatTime) {
        StringBuffer repeated = new StringBuffer();

        for (int i = 0; i < repeatTime; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }

    public void showPositions(HashMap<String, Integer> carPositions) {
        for (String carName: carPositions.keySet()) {
            System.out.print(carName + " : ");
            System.out.println(repeat("-", carPositions.get(carName)));
        }
        System.out.print("\n");
    }

    public void showHistoryOf(String leagueName) {
        LinkedHashMap<Integer, HashMap> trialRecords = leagueHistories.getHistoryOf(leagueName);
        for (int trial: trialRecords.keySet()) {
            showPositions(trialRecords.get(trial));
        }
    }

    public String pickWinners(HashMap<String, Integer> carPositions) {
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

    public void showWinnersOf(String leagueName, int trial) {
        String winners = pickWinners(leagueHistories.getHistoryOf(leagueName, trial));

        System.out.println(winners + "(이)가 최종 우승했습니다.");
    }
}