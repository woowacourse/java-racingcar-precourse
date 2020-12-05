package racingcar;

import racingcar.exception.ParticipantNameSizeOverException;
import utils.TextResource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReceptionDesk {
    public static final String SEPARATOR = ",";
    public static final int MAX_PARTICIPANTS_NAME_LENGTH = 5;

    public Cars applyCars(Scanner scanner) throws ParticipantNameSizeOverException {
        System.out.println(TextResource.STATEMENT_INPUT_CAR_NAME);
        String input = scanner.nextLine();
        List<String> participants = parseInput(input);
        checkParticipantNameValid(participants);
        return readyCars(participants);
    }

    private Cars readyCars(List<String> participants) {
        ArrayList cars = new ArrayList();
        for (String name : participants) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    private List<String> parseInput(String input) {
        return Arrays.asList(input.split(SEPARATOR));
    }

    private void checkParticipantNameValid(List<String> participants) throws ParticipantNameSizeOverException {
        for (String name : participants) {
            if (name.length() > MAX_PARTICIPANTS_NAME_LENGTH) {
                throw new ParticipantNameSizeOverException();
            }
        }
    }
}
