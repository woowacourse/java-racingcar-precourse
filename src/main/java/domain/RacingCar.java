package domain;

import java.io.*;

/*
 *
 * 자동차경주게임 클래스
 *
 * @ver 1.1
 * @author 이준규
 *
 * */

public class RacingCar {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void start() throws IOException {
        bw.write("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + "\n");
        bw.flush();
        String[] carNamesList = Input.readName(br);
        Car[] carList = Input.giveCarName(carNamesList);
        int numberOfCars = carNamesList.length;
        bw.write("시도할 회수는 몇회인가요?" + "\n\n");
        bw.flush();
        int movings = Input.countMovings(br);

        //Output out = new Output();
        //out.printResult(carNamesList,carList,movings);
        Output.printResult(carNamesList,carList,movings);
        int farthest = Output.FarthestLocation(carList,numberOfCars);
        Output.printWinner(carList,farthest);
    }



    public static void main(String[] args) throws IOException {
        RacingCar RacingCarGame = new RacingCar();
        RacingCarGame.start();
    }
}