package racingcar.view;

import racingcar.message.outputMessage;
import racingcar.model.Car;

public class outputView {

    public void round(Car dto) {
        //out(outputMessage.GAME_ROUND);
        out(dto.getName()+" : ");
        out("-".repeat(dto.getPosition()));
        blank();
    }

    private void out(String text) {
        System.out.print(text);
    }

    private void blank() {
        System.out.println();
    }

}
