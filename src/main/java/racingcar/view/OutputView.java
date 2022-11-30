package racingcar.view;

import racingcar.dto.GameResultDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String CAR_NAME_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_TRY_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String MOVE_RESULT_GUIDE_MESSAGE = "\n실행 결과";
    private static final String NEW_LINE_DELIMITER = "\n";
    private static final String MOVE_RESULT_FORM = "%s : %s";
    private static final String POSITION_DISPLAY_BAR = "-";
    
    public void printCarNameInputGuideMessage() {
        println(CAR_NAME_INPUT_GUIDE_MESSAGE);
    }
    
    public void printNumberOfTryInputGuideMessage() {
        println(NUMBER_OF_TRY_INPUT_GUIDE_MESSAGE);
    }
    
    public void printMoveResultGuideMessage() {
        System.out.println(MOVE_RESULT_GUIDE_MESSAGE);
    }
    
    public void printMoveResult(final GameResultDTO gameResultDTO) {
        final List<String> movablesName = gameResultDTO.getMovablesName();
        final List<Integer> movablesPosition = gameResultDTO.getMovablesPosition();
        println(parseMoveResult(movablesName, movablesPosition));
        
    }
    
    private String parseMoveResult(final List<String> movablesName, final List<Integer> movablesPosition) {
        return IntStream.range(0, movablesName.size())
                .mapToObj(carIndex -> parseOneMoveResult(movablesName.get(carIndex), movablesPosition.get(carIndex)))
                .collect(Collectors.joining(NEW_LINE_DELIMITER));
    }
    
    private String parseOneMoveResult(final String movableName, final Integer movablePosition) {
        return String.format(MOVE_RESULT_FORM, movableName, parsePositionDisplay(movablePosition));
    }
    
    private String parsePositionDisplay(final Integer movablePosition) {
        return IntStream.range(0, movablePosition)
                .mapToObj(count -> POSITION_DISPLAY_BAR)
                .collect(Collectors.joining());
    }
    
    private void println(final String message) {
        System.out.println(message);
    }
    
    public void printErrorMessage(final IllegalArgumentException raisedException) {
        System.out.println(raisedException.getMessage());
    }
}
