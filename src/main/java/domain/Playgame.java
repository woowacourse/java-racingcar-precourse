package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Playgame {

    public static void main(String[] args) {

        GameFunction module = new GameFunction();

        module.initSetup();

        for (int i = 0; i < module.getRounds(); i++) {
            module.racing();
        }

        module.checkWinner();

    }
}
