## 우아한 테크코스 프리코스 2주차 미션 - 자동차 경주 게임

### 게임 설명

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈춘다.

* 각 자동차에 사용자가 이름을 부여하며, 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

* 자동차 이름은 쉼표( , )를 기준으로 구분하며 이름은 5자 이하만 가능하다.

* 사용자는 몇 번의 이동을 할 것인지를 입력 한다.

* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진,  
   3 이하의 값이면 멈춘다.

* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 

### 프로그램 실행 결과 예시

**경주할 자동차 이름을 입력하세요.(이름은 쉼표( , ) 기준으로 구분)**  
pobi,crong,honux

**시도할 회수는 몇회인가요?**  
5

**실행 결과**

**pobi : -**  
**crong : -**  
**honux : -**  

**pobi : --**  
**crong : -**  
**honux : --**  

**pobi : ---**  
**crong : --**  
**honux : ---**  

**pobi : ----**  
**crong : ---**  
**honux : ----**  

**pobi : -----**  
**crong : ----**  
**honux : -----**

**pobi, honux가 최종 우승했습니다.**

------

### 기능 구현 목록

 * Car 객체 생성 시 예외 처리
    * 자동차의 이름이 5자 이상인 경우
    * 이름에 공백이 있는 경우
    * 이름이 비어있는 경우
 
* 분리한 자동차이름으로 자동차 리스트 Cars를 만드는 기능

 * Cars 객체 생성 시 예외 처리
    * Car 객체가 2대 이상이 아닌 경우
    * Car 객체가 중복된 이름을 가진 경우

* RepetitionNumber 객체 생성 시 예외 처리
    * 시도 회수가 1이상이 아닌 경우 예외 처리
            
* 각각의 차에서 0에서 9사이의 random 값을 구해서 값에 따라 position을 증가시키는  기능

* Cars의 toString을 이용해 현재 차의 상태를 리턴하는 기능

* 경주 결과를 저장한 RaceResult를 만드는 기능

* 경주 결과들을 저장한 RaceResults를 만드는 기능

* 최종우승자를 찾아내는 기능 

* 최종우승자로 GameResult를 생성하는 기능

* 입력 받은 시도 회수 만큼 게임을 진행하는 기능

* 입력받는 기능
    * 자동차 이름들 입력
    * 시도할 회수 입력

* 출력 기능
    * 실행 결과를 출력하는 기능
    * 최종 우승자들을 출력하는 기능
    * 에러 메세지를 출력하는 기능
    
* 게임 진행 로직