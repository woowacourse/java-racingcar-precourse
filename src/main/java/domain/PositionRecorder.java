package domain;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void showHistoryOf(String leagueName) {

    }
}