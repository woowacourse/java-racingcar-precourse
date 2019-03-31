package domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingGame implements RacingGameInterface {
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private String playerName = "";
    private ArrayList<String> nameArrayList = new ArrayList<String>();
    private ArrayList<Car> carList = new ArrayList<Car>();
    private ArrayList<Car> winner = new ArrayList<Car>();
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
    

    public boolean checkNumberOrNot(String moveCountStr) {
        boolean isWrongInputNumber = false;
        
        for (int i = 0; i < moveCountStr.length(); i++) {
            if (moveCountStr.charAt(i) < 48 || moveCountStr.charAt(i) > 57) {
                System.out.println("시도할 회수로 숫자를 입력해야합니다.");
                isWrongInputNumber = true;
                break;
            } 
        }
        
        if (isWrongInputNumber == false) {
            isWrongInputNumber = checkMoveCountInputOrNot(moveCountStr);
        }
        
        return isWrongInputNumber;
    }


    public boolean checkMoveCountInputOrNot(String moveCountStr) {
       boolean isNotInput = false;
        
        if (moveCountStr.length() == 0) {
            System.out.println("시도할 회수가 입력되지 않았습니다.");
            isNotInput = true;
            return isNotInput;
        }
        
        if (Integer.parseInt(moveCountStr) == 0) {
            System.out.println("레이스를 위해 0 이상의 숫자를 입력해주세요.");
            isNotInput = true;
        }
        
        return isNotInput;
    }
    
    public void startRace() {
        nameArrayList = setPlayerName();
        carList = makePlayers(nameArrayList);
        moveCount = inputMoveCount();
        
        for (int i = 0; i < moveCount; i++) {
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).moveCar(random.nextInt(10));
                carList.get(j).printRaceSituation();
            }
            
            System.out.println("\n\n");
        }
    }

    @Override
    public ArrayList<Car> judgeWinner(ArrayList<Car> carList) {
        int maxPosition = 0;
        
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() > maxPosition) {
                maxPosition = carList.get(i).getPosition();
            }
        }
        
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() == maxPosition) {
                winner.add(carList.get(i));
            }
        }
        
        return winner;
    }
    
    public void printWinner() {
        winner = judgeWinner(carList);
        
        for (int i = 0; i < winner.size() - 1; i++) {
            System.out.print(winner.get(i).getName() + ", ");
        }
        
        System.out.println(winner.get(winner.size()-1).getName() + "가 최종 우승했습니다.");
    }

    public static void main(String[] args) {
        RacingGame rg = new RacingGame();
        rg.startRace();  
        rg.printWinner();
    }

}