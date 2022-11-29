package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarPositionDto;
import racingcar.dto.WinnerDto;

public class OutputView {

    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String CAR_POSITION_MARK = "-";

    public void printRunMessage() {
        System.out.println("실행 결과");
    }

    public void printCarsPosition(List<CarPositionDto> carPositionDtos) {
        carPositionDtos.stream()
                .forEach(this::printEachCarPosition);
        System.out.println();
    }

    public void printWinnerNames(List<WinnerDto> winnerDtos) {
        List<String> winnerNames = getWinnerNames(winnerDtos);
        System.out.printf("최종 우승자 : %s\n", String.join(WINNER_NAME_DELIMITER, winnerNames));
    }

    private void printEachCarPosition(CarPositionDto carPositionDto) {
        System.out.printf("%s : %s\n", carPositionDto.getName(), getPositionMark(carPositionDto.getPosition()));
    }

    private String getPositionMark(int position) {
        return CAR_POSITION_MARK.repeat(position);
    }

    private List<String> getWinnerNames(List<WinnerDto> winnerDtos) {
        return winnerDtos.stream()
                .map(WinnerDto::getName)
                .collect(Collectors.toList());
    }
}
