package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.domain.RandomNumber;
import racingcar.domain.repository.CarRepositoryImpl;
import racingcar.service.CarRaceService;
import racingcar.view.DefaultView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        CarRaceService service = new CarRaceService(new RandomNumber(), new CarRepositoryImpl());
        CarRaceController controller = new CarRaceController(service);
        DefaultView view = new DefaultView(new OutputView(), new InputView(), controller);
        view.render();
    }
}
