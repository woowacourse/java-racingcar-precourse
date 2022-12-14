package racingcar.view;

import java.util.List;
import racingcar.dto.CarDTO;
import racingcar.dto.CarStatusDTO;
import racingcar.view.constants.Format;
import racingcar.view.constants.OutputMessage;
import racingcar.view.util.FormatParser;

public class OutputView {
    public void printGameResult(List<CarStatusDTO> carStatuses) {
        System.out.println(OutputMessage.GAME_RESULT);
        carStatuses.forEach(this::printCarStatuses);
    }

    private void printCarStatuses(CarStatusDTO carStatusDTO) {
        List<CarDTO> cars = carStatusDTO.getCars();
        cars.forEach(this::printCar);
        System.out.println();
    }

    private void printCar(CarDTO carDTO) {
        System.out.printf(Format.OUTPUT_CAR_STATUS_FORMAT, carDTO.getName(),
                FormatParser.make(carDTO.getPosition(), Format.OUTPUT_CAR_POSITION_UNIT));
    }

    public void printWinners(List<String> winnerNames) {
        System.out.printf(Format.OUTPUT_WINNERS_FORMAT, FormatParser.join(winnerNames, Format.OUTPUT_NAMES_DELIMITER));
    }

    public void printErrorMessage(String message) {
        System.out.printf(Format.OUTPUT_ERROR_FORMAT, message);
    }
}
