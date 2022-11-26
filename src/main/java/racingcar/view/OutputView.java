package racingcar.view;

import java.util.List;
import racingcar.dto.CarPositionDto;

public class OutputView {

    public void printCarsPosition(List<CarPositionDto> carPositionDtos) {
        carPositionDtos.stream()
                .forEach(this::printEachCarPosition);
    }

    private void printEachCarPosition(CarPositionDto carPositionDto) {
        System.out.printf("%s : %s\n", carPositionDto.getName(), getPositionMark(carPositionDto.getPosition()));
    }

    private String getPositionMark(int position) {
        return "-".repeat(position);
    }
}
