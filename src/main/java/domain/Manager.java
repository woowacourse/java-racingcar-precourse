package domain;

import java.util.Random;
import java.util.Vector;

public class Manager {
    private Vector<Car> carList;
    private User user;
    private int tryCount;

    public Manager(){
        user = new User();
    }

    public void startGame() {
        int winnerPostion=0;

        while (firstQuery() == false) ;
        while (secondQuery() == false) ;

        System.out.println("실행 결과");
        for(int i=0; i<tryCount; i++){
            playIthTurn();
            printCurrentState();
        }
        winnerPostion = getMaxPostion();
        printWinner(winnerPostion);
    }

    public void printWinner(int winnerPosition) {
        boolean isFirst = true;
        for (int i = 0; i < carList.size(); i++) {
            if(carList.get(i).getPosition() == winnerPosition){
                firstWinnerOrNot(isFirst, carList.get(i).getName());
                isFirst = false;
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public void firstWinnerOrNot(boolean isFirst, String carName){
        if(isFirst == false) System.out.print(", ");
        System.out.print(carName);
    }

    public int getMaxPostion() {
        int maxPosition = 0;
        for (int i = 0; i < carList.size(); i++) {
            maxPosition = max(maxPosition, carList.get(i).getPosition());
        }
        return maxPosition;
    }
    public int max(int a, int b){
        return (a > b) ? a : b;
    }

    public void printCurrentState(){
        for(int i=0; i<carList.size(); i++){
            System.out.print(carList.get(i).getName() + ":");

            for(int j=0; j<carList.get(i).getPosition(); j++){
                System.out.print("-");
            }

            System.out.println();
        }

        System.out.println();
    }

    public void playIthTurn(){
        for(int i=0; i<carList.size(); i++){
            if(3 < getRandomNumber()){
                carList.get(i).forward();
            }
        }
    }

    public int getRandomNumber(){
        Random generator = new Random();
        return generator.nextInt(10);
    }

    public boolean secondQuery(){
        System.out.println("시도할 회수는 몇회인가요?");
        String ret = user.inputTryCount();
        try{
            Integer.parseInt(ret);
        }catch(NumberFormatException e){
            System.out.println(InputError.NUMBER_FORMAT_ERROR);
            return false;
        }
        tryCount = Integer.parseInt(ret);
        return true;
    }

    public boolean firstQuery(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        carList = user.inputCarName();
        return checkCarName();
    }

    public boolean checkCarName(){
        for(int i=0; i<carList.size(); i++) {
            if(carList.get(i).getName().length() > 5) {
                System.out.println(InputError.LENGTH_ERROR);
                return false;
            }
        }
        return true;
    }
}
