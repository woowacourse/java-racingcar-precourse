package domain;

import java.util.ArrayList;

public class RaceingGameController {

    public void gameStart(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<Car> carNameList = Input.getInstance().enrollCarName();

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Input.getInstance().tryNumber();

        gameResult(carNameList, tryNumber);

    }

    private void gameResult(ArrayList<Car> carNameList, int tryNumber){
        for(int i = 0 ; i < tryNumber ; i++){
            racingStart(carNameList);
            System.out.println();
        }

        ArrayList<String> winnerList = new ArrayList<>();
        int max = -1;

        for(int i=0; i < carNameList.size() ; i++){
            if(carNameList.get(i).getPosition() > max) {
                max = carNameList.get(i).getPosition();
                winnerList.clear();
                winnerList.add(carNameList.get(i).getName());
            } else if(carNameList.get(i).getPosition() == max) {
                winnerList.add(carNameList.get(i).getName());
            }
        }

        for(int i = 0 ; i < winnerList.size() ; i++){
            if(i == (winnerList.size()-1)){
                System.out.print(winnerList.get(i));
                break;
            }
            System.out.print(winnerList.get(i)+",");
        }

        System.out.println("가 최종 우승했습니다.");

    }

    private void racingStart(ArrayList<Car> carNameList){
        for(Car car : carNameList){
            car.movePosition();

            System.out.printf("%s : ", car.getName());
            for (int j = 0; j < car.getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }

    }

}
