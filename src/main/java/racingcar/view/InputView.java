package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class InputView {

    public Cars sendNamesOfParticipatingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesOfParticipatingCars = Console.readLine();
        List<Car> cars = Arrays.stream(namesOfParticipatingCars.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public String sendCountOfMoves() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
