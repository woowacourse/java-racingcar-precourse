package domain;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

class GetGameNumberInput {
    static int getGameNumberInput() {
        int gameNumber = 0;
        Scanner carNameInput = new Scanner(System.in);

        System.out.println("시도할 회수는 몇 번인가요?");
        gameNumber = parseInt(carNameInput.next());

        return gameNumber;
    }
}