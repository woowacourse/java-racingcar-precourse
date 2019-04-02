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
## 클래스
 
   * Car
   * RunningCarRacing
   * RacingResultPrinter
   * UserInputReciever
   * CarGenerator
   * RandomNumberGenerator
   * RaceAttemptReciever
     

****
## 주요 기능

   1. 자동차의 이름을 입력받은 예외를 처리하는 기능 (RecieveCarNamesFromUser)
   
   2. 자동차들의 이름을 입력받긴 하지만 예외가 있다면 예외를 던지는 기능 (tryToReceiveCarnamesFromUser)
   
   3. 자동차들의 이름이 전부 5이하인지 판단하는 기능 (isValidCarNamesInput)
   
   4. 자동차의 이름의 길이가 5이하인지 판단하는 기능 (isValidCarName)
      
   5. 입력받은 자동차들의 이름으로 객체를 생성하는 기능(GenerateCar)
      
   6. 자동차들의 운행 횟수를 입력받은 예외를 처리하는 기능 (RecieveRaceAttemptFromUser)
      
   7. 자동차들의 운행 횟수를 입력받긴 하지만 예외가 있다면 예외를 던지는 기능 (tryToRecieveRaceAttemptFromUser)
    
   8. 자동차의 운행 횟수가 1이상인지 판단하는 기능(isValidRaceAttempt)
     
   9. 난수를 생성하는 기능 (GenerateRandomNumber)
         
   10. 생성한 난수를 토대로 갈지 멈출지를 판단하는 기능 (isGo)
      
   11. 앞으로 가거나 멈추는 기능 (Go, Stop)
      
   12. 결과를 출력하는 기능 (PrintResult)