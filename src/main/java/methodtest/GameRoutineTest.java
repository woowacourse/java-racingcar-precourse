package methodtest;

import inpututils.InputName;
import inpututils.inputRepetitions;
import racingcar.GameManagement;

import java.util.Scanner;

public class GameRoutineTest {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameManagement gameTest = new GameManagement(new InputName(scanner).inputPlayerName(), new inputRepetitions(scanner).inputanswer());
    }
}
