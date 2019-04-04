package domain;

import java.util.HashMap;

public class LeagueHistoryDB {
    private HashMap<String, HashMap> leagueHistories = new HashMap<String, HashMap>();

    public void createNewHistroy(String leagueName) {
        HashMap<Integer, HashMap> trialRecords = new HashMap<Integer, HashMap>();
        leagueHistories.put(leagueName, trialRecords);
    }

    public void writeHIstory(String leagueName, int trial, HashMap carPositions) {
        if (!leagueHistories.containsKey(leagueName)) {
            createNewHistroy(leagueName);
        }
        leagueHistories.get(leagueName).put(trial, carPositions);
    }

    public HashMap getHistoryOf(String leagueName) {
        return new HashMap();
    }

    public HashMap getHistoryOf(String leagueName, int trial) {
        return new HashMap();
    }
}