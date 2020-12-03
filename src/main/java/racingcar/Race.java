package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    public static Winners start(List<Car> cars, int tryCount) {
        // todo 각 차수별 실행 결과 구하기
        List<Car> winners = new ArrayList<>();

        System.out.println("%n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {

            }
        }

        return new Winners(winners);
    }
}
