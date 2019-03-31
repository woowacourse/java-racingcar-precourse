package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame implements RacingGameInterface {
    private Scanner sc = new Scanner(System.in);
    private String playerName = "";
    private ArrayList<String> nameArrayList = new ArrayList<String>();
    private ArrayList<Car> carList = new ArrayList<Car>();
    private int moveCount = 0; 
    
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
    
    /**
     * inputPlayerName()로 자동차의 이름을 입력받고 자동차의 이름이 5자 이하인지 확인해 
     * 최종적으로 자동차 이름을 nameArrayList에 저장합니다.
     */
    public ArrayList<String> setPlayerName() {
        boolean validatedPlayerName = true;

        while (validatedPlayerName) {
            playerName = inputPlayerName();
            nameArrayList = convertStringNameToArrayList(playerName);
            validatedPlayerName = checkPlayerNameLength(nameArrayList);
        }
        
        return nameArrayList;
    }

    /**
     * 입력받은 이름을 생성자의 인자로 넘겨 Car객체를 생성합니다.
     */
    public ArrayList<Car> makePlayers(ArrayList<String> nameArrayList) {
        for (int i = 0; i < nameArrayList.size(); i++) {
            carList.add(new Car(nameArrayList.get(i)));
        }

        return carList;
    }

    @Override
    public int inputMoveCount() {
        boolean wrongInput = true;
        String moveCountStr = "0";
        
        while (wrongInput) {
            System.out.println("시도할 회수는 몇회인가요?");
            moveCountStr = sc.nextLine();
            wrongInput = checkNumberOrNot(moveCountStr);
        }
        
        moveCount = Integer.parseInt(moveCountStr);
        
        return moveCount;
    }
    
    @Override
    public boolean checkNumberOrNot(String moveCountStr) {
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