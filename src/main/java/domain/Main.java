package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

        static Car[] cars;
        static int n;

        public static void main(String args[]) throws IOException{
                inputNames();
                inputRandomNumber();
                playRace();
                compare();
                outputWinner();
        }

        public static void inputNames() throws IOException {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                String names = bf.readLine();
                String[] name = names.split(",");
                makeCars(name);
        }

        public static void makeCars(String[] name){

        }

        public static void inputRandomNumber(){

        }

        public static void playRace(){

        }

        public static void gameOnce(){

        }

        public static void compare(){

        }

        public static void findMaximum(){

        }

        public static void outputWinner(){

        }
}
