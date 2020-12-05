package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Track track = new Track(new ArrayList<>(), new ArrayList<>());
        track.start(scanner);
    }
}
