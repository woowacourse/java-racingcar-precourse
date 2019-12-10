# 자동차 경주 게임
    프로그램 시작 시 n개의 자동차 이름과 횟수를 입력받는다
    자동차들은 매 회마다 랜덤으로 전진, 정지를 결정한다
    사용자가 정한 count만큼 게임이 진행되면 가장 많이 진행한 자동차가 승리한다


## 사용법
    import domain.Car;
    import sources.CarRaceSource;
    import utils.UtilityMethods;
    
    import java.util.ArrayList;
    import java.util.Scanner;
    
    public class CarRaceGame {
    	public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    
    		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    		String inputString = sc.nextLine();
    		System.out.println("시도할 회수는 몇회인가요?");
    		int count = sc.nextInt();
    		Car[] cars = UtilityMethods.sliceString(inputString);
    		CarRaceSource.playGameByNumber(count, cars);
    		ArrayList<String> winners = CarRaceSource.judgeWinner(cars);
    		CarRaceSource.printWinner(winners);
    	}
    }

    
## 기능 설명

 ###CarRaceGame
 - void playGameByNumber(int count, Car cars[])

        게임에 참여하는 자동차의 목록과 반복 횟수를 입력받아 자동차 경주 시합을 실행하는 메소드
        
 - void goForwardRandomly(Car[] cars)

        playGameByNumber에서 호출되어 게임에 참가하는 자동차들을 랜덤하게 전진시키는 메소드
        
 - void printRoundResult(Car cars[])
        
        playGameByNumber에서 호출되어 한 라운드가 수행된 뒤 라운드의 결과를 출력하는 메소드
        
 - ArrayList<String> judgeWinner(Car[] cars)

        모든 라운드가 끝난뒤 실행되는 메소드로 게임에 참여한 자동차들을 입력받아 
        우승자의 List를 리턴하는 메소드 (동시 우승자를 핸들하기위해 List 사용)
        
 - judgeWinningPosition(Car[] cars)
        
        judgeWinner에서 호출되어 게임에 참여한 자동차들의 최종 위치를 순회하여
        가장 멀리 간 자동차의 위치를 리턴하는 메소드
        
 - printWinner(ArrayList<String> winners)

        judgeWinner에서 리턴된 List를 입력받아 양식에 맞게 출력하는 메소드
        
        
 ###UtilityMethods
 - Car[] sliceString(String target)
 
        유저에게서 입력 받은 스트링을 ',' 기준으로 나누고 자동차 객체를 생성하는 메소드
        
 - String getListToString(ArrayList<String> winners)
 
        printWinner에서 호출되어 입력받은 리스트를 출력 양식에 맞는 문자열로 변환하여 리턴하는 메소드