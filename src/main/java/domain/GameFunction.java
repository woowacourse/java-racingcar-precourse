package domain;


import java.util.ArrayList;
import java.util.Scanner;

public class GameFunction {

    private ArrayList<Car> carlist;
    private String inputCarname = null;
    private String inputRound = null;
    private int winnerPoint = 0;

    public GameFunction() {
        carlist = new ArrayList<>();
    }

    private static int initSetup() {

        while (!inputCarname()) ;

        while (!inputRoundturn()) ;

        createCar();

    }

    private boolean setCarname() {

        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");

        this.inputCarname = scan.nextLine();
        String[] carNameSplit = this.inputCarname.split(",");

        for (int i = 0; i < carNameSplit.length; i++) {
            if (carNameSplit[i].length() < 1 || carNameSplit[i].length() > 5)
                return false;
        }

        return true;
    }

    private boolean setRounds() {

        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        this.inputRound = scan.nextLine();
        int num = 0;

        for (int i = 0; i < this.inputRound.length(); i++) {
            try {
                num = Integer.parseInt(inputRound);
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    private static void createCar(String input, ArrayList<Car> carlist) {

        String[] carNameSplite = input.split(",");

        for (int i = 0; i < carNameSplite.length; i++) {
            carlist.add(new Car(carNameSplite[i]));
        }

    }

    public void race() {

        System.out.println("실행결과");

        for (int j = 0; j < carlist.size(); j++) {
            this.carlist.get(j).goAndStop();
            this.carlist.get(j).printDistance();
            this.winnerPoint = Math.max(this.winnerPoint, this.carlist.get(j).getPosition());
        }

        System.out.println();
    }



    public String getSetCarname() {
        return inputCarname;
    }

    public int getSetRounds() {
        return Integer.parseInt(inputRound);
    }

}
