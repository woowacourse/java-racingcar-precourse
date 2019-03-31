package domain;

import java.util.ArrayList;

public interface RacingGameInterface {
    
    abstract String inputPlayerName();
    abstract ArrayList<String> convertStringNameToArrayList(String name);
    abstract boolean checkPlayerNameLength();
    abstract ArrayList<Car> makePlayers();
    abstract String inputMoveCount();
    abstract boolean checkNumberOrNot();
    abstract ArrayList<Car> judgeWinner();
    abstract void startRace();

}