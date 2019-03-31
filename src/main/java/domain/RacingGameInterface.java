package domain;

import java.util.ArrayList;

public interface RacingGameInterface {
    
    /** 자동차 이름 입력 받기  */ 
    abstract String inputPlayerName();
    abstract ArrayList<String> convertStringNameToArrayList(String name);
    abstract boolean checkPlayerNameLength(ArrayList<String> nameList);
    abstract ArrayList<String> setPlayerName();
    
    /** 자동차 객체 생성  */
    abstract ArrayList<Car> makePlayers(ArrayList<String> nameArrayList);
    
    /** 실행 회수 입력 받기  */
    abstract int inputMoveCount();
    abstract boolean checkNumberOrNot(String moveCountStr);
    
    /** 승자 판정  */
    abstract ArrayList<Car> judgeWinner();
    
    /** 게임 시작 */
    abstract void startRace();

}