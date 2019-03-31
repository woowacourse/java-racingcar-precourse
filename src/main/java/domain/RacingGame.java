package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame implements RacingGameInterface {
    private Scanner sc = new Scanner(System.in);
    private String playerName = "";
    
    public String inputPlayerName() {
        boolean nameNotInput = true;
        
        while (nameNotInput) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
            playerName = sc.nextLine();
            
            if (playerName.length() != 0) {
                nameNotInput = false;
            }
        }

        return playerName;
    }

    @Override
    public boolean checkPlayerNameLength() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<Car> makePlayers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String inputMoveCount() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean checkNumberOrNot() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<Car> judgeWinner() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void startRace() {
        // TODO Auto-generated method stub
        
    }
    
    public static void main(String[] args) {
        
    }
}