package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Playgame {

    public static void main(String[] args) {


        public static void main(String[] args) {

            GameFunction module = new GameFunction();

            module.initSetup();

            for (int i = 0; i < module.getSetRounds(); i++) {
                module.race();
            }

            module.checkWinner();

        }
}
