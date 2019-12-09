package com.minuyim.race;

import com.minuyim.race.domain.Race;
import com.minuyim.race.domain.Winner;

public class Main {

    public static void main(String[] args) {
        Race race = new Race();
        race.startRace();
        Winner winner = new Winner(race);
        winner.printWinner();
    }
}