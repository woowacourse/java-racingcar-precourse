package racingcar;

import java.util.ArrayList;

/**
 * @apiNote
 * printRacingResult 메서드는 매 회차마다 경기 결과를 요구 형식에 맞게 출력한다.
 * printRacingWinner 메서드는 최종 우승자를 요구 형식에 맞게 출력한다.
 *
 * @author 장준영
 */

public class Print {
    public void printRacingResult(ArrayList<Car> cars){
        for(Car car: cars){
            System.out.print(car.getName());
            System.out.print(" : ");
            for(int i = 0; i < car.getPosition(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printRacingWinner(ArrayList<String> nameOfWinner){
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < nameOfWinner.size(); i++){
            System.out.print(nameOfWinner.get(i));
            if(i != nameOfWinner.size()-1){             // 마지막 순서가 아니라면 쉼표(,)를 출력 형식에 추가한다.
                System.out.print(", ");
            }
        }
    }
}
