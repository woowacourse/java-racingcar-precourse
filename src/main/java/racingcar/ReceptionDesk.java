package racingcar;

import racingcar.exception.ParticipantNameSizeOverException;
import utils.TextResource;

import java.util.ArrayList;
import java.util.Scanner;

public class ReceptionDesk {

    public Cars applyCars(Scanner scanner) throws ParticipantNameSizeOverException {
        System.out.println(TextResource.STATEMENT_INPUT_CAR_NAME);
        String input = scanner.nextLine();
        return new Cars(new ArrayList<>());
    }

}
