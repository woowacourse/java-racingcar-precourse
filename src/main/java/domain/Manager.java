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

    /**
     * 두 개의 질문에 대한 입력을 받고 시도횟수 만큼 각 자동차에 랜덤 값을 부여하여
     * 조건에 맞으면 전진하고 아니면 멈춰있는걸 반복한다. 그 후 우승자를 출력한다.
     */
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

    /**
     * 시도 횟수의 매 턴마다 자동차들의 경주 상태를 출력한다.
     */
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

    /**
     * 랜덤 넘버를 이용하여 i번째 자동차를 앞으로 전진하게 하는 조건이면
     * 앞으로 전진하게 한다.
     */
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

    /**
     * 모든 자동차의 이름의 길이가 5이하 인지 체크한다.
     * @return boolean
     */
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
