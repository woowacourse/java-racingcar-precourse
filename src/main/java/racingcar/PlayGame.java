package racingcar;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collection;

public class PlayGame {
    private static final String INPUT_RACING_CAR_NAME="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_NUMBER="시도할 회수는 몇회인가요?";
    private static final String FINAL_WINNER_NAME="최종 우승자: ";
    private String tmpCarNameSave;
    private String[] carNameSave;
    private String inputStringAttemptNumber;
    private int doAttemptNumber;
    private Car[] carObject;
    ComputeRelatedCar computeRelatedCar=new ComputeRelatedCar();
    ExceptionHandle exceptionHandle=new ExceptionHandle();
    public PlayGame(Scanner scanner) {
        startRacingCar(scanner);
    }
    public void startRacingCar(Scanner scanner){
        inputRacerName(scanner);
        inputAttemptNumber(scanner);
        splitCommaInString(scanner);

        implementGetPrintCarPositionToMinus();
    }
    public void inputRacerName(Scanner scanner){
        System.out.println(INPUT_RACING_CAR_NAME);
        this.tmpCarNameSave=scanner.nextLine();
        splitCommaInString(scanner);
    }
    public void inputAttemptNumber(Scanner scanner){
        System.out.println(INPUT_ATTEMPT_NUMBER);
        inputStringAttemptNumber = scanner.nextLine();
        if(!exceptionHandle.checkInputAttemptNumber(inputStringAttemptNumber)){
            inputAttemptNumber(scanner);
        }
        this.doAttemptNumber=Integer.parseInt(inputStringAttemptNumber);
    }
    public void splitCommaInString(Scanner scanner){
        if(!exceptionHandle.checkInputString(tmpCarNameSave)){
            inputRacerName(scanner);
        }
        carNameSave=tmpCarNameSave.split(",");
        makingCarObjectArray();
    }
    public void makingCarObjectArray(){
        carObject=new Car[carNameSave.length];
        for(int i=0;i<carObject.length;i++){
            carObject[i]=new Car(carNameSave[i]);
        }
    }
    public void printCarPositionToMinus(Car tmpCarObjectParameter){
        System.out.println();
        tmpCarObjectParameter.decidePositionNumber();
        System.out.print(tmpCarObjectParameter.getName()+" : ");
        for(int i=0;i<tmpCarObjectParameter.getPosition();i++){
            System.out.print("-");
        }

    }
    public void getPrintCarPositionToMinus(){
        for(int i=0;i<carObject.length;i++){
            printCarPositionToMinus(carObject[i]);
        }
    }
    public void implementGetPrintCarPositionToMinus(){
        for(int i=0;i<doAttemptNumber;i++){
            getPrintCarPositionToMinus();
            System.out.println();
        }
        printWinnerName();
    }
    public void printWinnerName(){
        System.out.println();
        System.out.print(FINAL_WINNER_NAME);
        Arrays.sort(carObject);
        int winnerNumber=computeRelatedCar.getWinnerNumber(carObject);
        for(int i=0;i<winnerNumber;i++){
            if(i<winnerNumber-1){
                System.out.print(carObject[i].getName()+", ");
            }
            if(i==winnerNumber-1){
                System.out.print(carObject[i].getName());
            }
        }
    }
}
