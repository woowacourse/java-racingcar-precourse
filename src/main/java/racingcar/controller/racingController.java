package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.inputView;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.outputView;

import java.util.ArrayList;
import java.util.List;

public class racingController {

    private final inputView inputView = new inputView();
    private final outputView outputview = new outputView();

    public void start() {
        String[] names = inputView.getNames();
        int round = inputView.getRound();

        List<Car> hs = new ArrayList<>();
        //이름 갯수 만큼 객체 저장
        for(int i=0; i<names.length; i++) {
            String name = names[i];
            hs.add(new Car(name,0));
        }

        //round만큼 포지션 업데이트
        for(int j=0; j<round; j++){
            for (int k=0; k<hs.size(); k++){
                int randomNum = Randoms.pickNumberInRange(0,9);
                if (randomNum >= 4) {
                    hs.get(k).setPosition(hs.get(k).getPosition()+1);
                }
            }
        }

        for(Car car : hs) {
            outputview.round(car);
        }
    }
}
