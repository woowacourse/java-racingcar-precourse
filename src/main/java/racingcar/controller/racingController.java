package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.racingGame;
import racingcar.view.inputView;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.outputView;

import java.util.ArrayList;
import java.util.List;

public class racingController {
    private final racingGame racinggame = new racingGame();
    private final inputView inputView = new inputView();
    private final outputView outputview = new outputView();

    public void start() {
        String[] names = inputView.getNames();
        int round = inputView.getRound();

        List<Car> cars = racinggame.saveCars(names); //객체 저장

        System.out.println();
        System.out.println("실행 결과");

        for(int i=0; i<round; i++) {
            racinggame.updatePhase(cars);
            outputview.round(cars);
        }

        //최고점 저장
        int temp = 0;
        for(int m=0; m<cars.size(); m++){
            if (temp<cars.get(m).getPosition()){
                temp = cars.get(m).getPosition();
            };
        }

        //최종 결과 출력
        String result = "최종 우승자 : ";
        for(int n=0; n<cars.size(); n++){
            if(cars.get(n).getPosition() == temp) {
                result += cars.get(n).getName();
            }
        }

        System.out.println(result);

    }
}
