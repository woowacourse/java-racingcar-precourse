# 프리코스 2주차 자동차 경주 게임 
==============================

## 프로젝트 설명

  ### 기능 요구 사항
  * 주어진 횟수동안 n대의 자동차는 전진 또는 멈출 수 있다.
 
  * 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 
  * 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
 
  * 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 
  * 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4이상일 경우 전진하고, 3이하의 값이면 멈춘다.
 
  * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
 
  ### 프로그래밍 요구사항
   * 자바 코드 컨벤션을 지키면서 프로그래밍한다.
 
   * indent depth를 3이 넘지 않도록 구현한다.
 
   * 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
 
   * else 예약어를 쓰지 않는다.
 
  ### 사용 예시
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,crong,honux
    시도할 회수는 몇회인가요?
    5
    
    실행결과 
    pobi:- 
    crong:-
    honux:-
    
    pobi:--
    crong:-
    honux:--
    
    pobi:---
    crong:--
    honux:---
    
    pobi:----
    crong:---
    honux:----
    
    pobi:-----
    crong:----
    honux:-----
    
    pobi,honux가 최종 우승했습니다.
 
 ****
## 클래스 및 메소드설명
 
  * **(Class) RacingGame (Main메소드 포함)**<br/>
  
    * Start : 전체적인 게임을 진행하는 기능입니다. <br/>
        * MoveCarsAndPrintAllResults : 차를 움직이고 결과를 출력하는 메소드들을 호출하는 기능입니다.<br/>
  
  * *(Class)CarNameReciever*
  
    * RecieveCarNamesFromUser : 사용자로부터 입력을 받는 기능을 시도하는 메소드를 호출하고 예외를 처리합니다,
     
        * tryToRecieveCarNamesFromUser : 사용자로부터 입력을 실제로받고 예외가있는지 판단하는 메소드를 호출합니다.
        
            * ThrowExceptionIfInvalidCarName : 차의이름들이 올바른지 판단하는 메소드를 호출하고 판단해서 예뢰를 생성해 던집니다.
            
                * isInValidCarNames : 차의 이름들이 올바른지 판단하기위해 차의수만큼 루프를돌고 각 차가 올바른 입력인지 판단하는 메소드를 호출합니다.
                
                    * isValidCarName : 차의 이름이 올바른지 판단합니다.        
  
  * *(Class)CarGenerator*
  
    * GeneraterCar : 리스트에 차의객체를 생성해서 넣는 메소드입니다.
    
    * getCarList : 차 객체를 담고있는 리스트의 Getter입니다. 
  
  * *(Class)RaceAttemptReciever*
  
    * RecieveRaceAttemptFromUser : 사용자에게 실제로 시도할 횟수를 입력받는 메소드를 호출하고 예외를 처리합니다.
    
        * tryToRecieveRaceAttemptFromUse : 사용자에게 실제로 시도할 횟수를 입력받고 예외를 생성하는 메소드를 호출합니다.
        
            * ThrowExceptionIfInavlidRaceAttempt : 예외인지 판단하는 메소드를 호출하고 예외라면 예외를 생성합니다.
            
                * isInValidRaceAttempt : 시도할 횟수가 예외인지 판단합니다.
  
  * *(Class)CarNavigator*
  
    * MoveCars : 차의수만큼 루프를돌며 차가 이동할 수 있다면 이동하는 메소드를 호출합니다.
    
        * MoveCarIfPossible : 차가 이동할 수 있는지 판단하는 메소드를 호출하고 차를 움직이는 메소드를 호출합니다.
            
            * isMove : 난수를 토대로 차가 이동가능한지를 확인합니다.
            
                * GenerateRandomNumber : 이동가능한지를 확인하기 위한 난수를 생성합니다.
               
            * MoveCar : 차를 실제로 움직입니다.
               
  * *(Class)RaceResultPrinter*
  
    * PrintEachRaceAttemptResult : 차의 수만큼 루프를 돌면서 각 시도별 차 한대의 결과를 출력해주는 메소드를 호출합니다.
        
        * PrintEachCarResult : 각 차 한대당 경주 결과의 거리를 출력하는 메소드를 호출하고 종합해 각 차 한대의 경주 결과를 출력합니다.
        
            * PrintRacingDistance : 각 차 한대의 경주 거리만을 출력하는 메소드 입니다.
  
  * *(Class)WinnerPrinter*
  
    * PrintWinner : 최대 경주 거리를 찾고, 최종 우승자를 찾아 우승자의 수만큼 루프를 돌며 우승자를 출력하는 메소드 입니다.
    
        * FindMaxDistance : 차의 수만큼 루프를 돌며 최대 경주 거리를 구하는 메소드 입니다.
        
            * SaveMaxDistanceIfIsTrue : 각 차가 현재의 최대 경주 거리보다 크면 최대 경주 거리를 갱신하는 메소드입니다.  
            
        * FindWinner : 차의 수만큼 루프를 돌며 우승자를 찾는 메소드입니다.
        
            * SaveWinnerNameIfIsTrue : 우승자를 찾았다면 리스트에 저장하는 메소드입니다. 
                
  * *(Class)Car*
  
    * Move : 차의 position을 1증가시켜 전진하는 메소드 입니다.
    
    * getName : 차의 이름을 리턴하는 Getter 입니다.
    
    * getPosition : 차의 위치를 리턴하는 Getter 입니다.  
    
 