package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame implements RacingGameInterface {
    private Scanner sc = new Scanner(System.in);
    private String playerName = "";
    private ArrayList<String> nameArrayList = new ArrayList<String>();
    
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
    
    /**
     * String타입으로 입력 받은 자동차 이름을 ,를 기준으로 나누어 nameArrayList에 담는 메서드
     */
    public ArrayList<String> convertStringNameToArrayList(String name) {
        String[] nameList = name.split(",");
        
        nameArrayList.clear();
        
        for (int i = 0; i < nameList.length; i++) {
            nameList[i] = nameList[i].trim();
            
            if (nameList[i].length() == 0) {
                continue;
            }
            
            nameArrayList.add(nameList[i]);
        }  // end for
        
        return nameArrayList;
    }
    
    
    public boolean checkPlayerNameLength(ArrayList<String> nameList) {
        boolean wrongLength = false;
        
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).length() > 5) {
                System.out.println("자동차 이름은 5자 이하여야 합니다.");
                wrongLength = true;
                return wrongLength;
            }
        }
        
        return wrongLength;
    }
    
    @Override
    public ArrayList<String> setPlayerName() {
        // TODO Auto-generated method stub
        return null;
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