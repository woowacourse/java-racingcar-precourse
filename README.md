#프리코스 2주차 미션 - 자동차 경주 

요구사항 : n대의 자동차를 생성 후, 경주과정을 보여주고, 우승자를 출력하는 프로그램을 만들자  
 1. 프로그램 구조  (Main 메소드)  
 1) 자동차 이름을 입력받는다. (쉼표를 기준으로 이름을 구분한다.)  
 2) 게임 라운드를 입력받는다.  
 3) 매 라운드 마다 자동차들의 진행 상황 출력한다.  
 4) 모든 라운드 종료시, 이동거리가 가장 큰 자동차를 우승자로 출력한다.   
     
 예외처리 : 입력 받는 이름중 5글자를 넘는 이름이 있으면 다시 이름 입력란으로 돌아간다.     
  
 2. 사용 클래스  
  
 1) Main 클래스 : 실행용 클래스  
   
  메소드  
  1. boolean isEffectiveFormat(String[] names)    
   - 예외처리용 메소드  
   - 입력받는 이름 글자 5글자 여부 확인.   
   - 모든글자 5자 이내면 true, 그렇지 않으면 false 반환.  
  
  2. void gameStart(Car[] cars, int currentRound,int totalRound)  
   - currentRound번째 경기 실행  
   - 자동차 객체들의 run,printState메소드 호출  
   - 해당 객체의 position값 과 maxPosition 비교하는 calMax메소드 호출  
   - totalRound에 도달할때까지 gameStart(currentRound+1,totalRound) 호출    
    
  3. void gameFinish(Car[] cars)  
   - 게임 결과 출력하는 메소드  
   - getWinner 메소드를 호출한 뒤, 반환문에서 이긴 차 이름들 가져온다.  
  
  4. ArrayList<Car> getWinner(Car[] cars)  
    - maxPosition과 position이 같은 차 객체 배열을 반환한다.  
    - gameFinish(cars) 메소드에서 사용한다.   
  
  5. void calMax(int position)  
   - 이동거리 최대값을 얻기 위해 자동차들의 현위치 position과 전역변수 maxPosition 비교
   - 둘 중 더 큰값을 maxPosition에 대입
  
 2) Car 클래스 : 경주용 자동차 클래스  
     
  필드   
  1. String name : 자동차 객체의 이름  
  2. int position : 자동차 객체의 현재 위치  
      
  메소드  
  1. void run() :  임의의 수 생성해 결과에 따라 position 변경  
  2. void printState() : 해당 객체의 경기진행내용을 출력  

