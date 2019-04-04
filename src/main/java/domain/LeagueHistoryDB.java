package domain;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LeagueHistoryDB {
    private HashMap<String, LinkedHashMap> leagueHistories = new HashMap<String, LinkedHashMap>();

    public void createNewHistroy(String leagueName) {
        LinkedHashMap<Integer, HashMap> trialRecords = new LinkedHashMap<Integer, HashMap>();
        leagueHistories.put(leagueName, trialRecords);
    }

    public void writeHIstory(String leagueName, int trial, HashMap<String, Integer> carPositions) {
        if (!leagueHistories.containsKey(leagueName)) {
            createNewHistroy(leagueName);
        }
        leagueHistories.get(leagueName).put(trial, carPositions);
    }

    public LinkedHashMap<Integer, HashMap> getHistoryOf(String leagueName) {
        return (LinkedHashMap) leagueHistories.get(leagueName);
    }

    public HashMap<String, Integer> getHistoryOf(String leagueName, int trial) {
        return (HashMap) leagueHistories.get(leagueName).get(trial);
    }
}