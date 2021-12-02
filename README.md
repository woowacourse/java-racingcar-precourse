# 미션 - 자동차 경주 게임

## 🔍 기능 정리

- 자동차 이름을 입력 받아 예외처리 한 뒤 자동차를 생성하는 기능
  - 예외처리 : 이름은 5자 이하만 가능, <추가> 공백이어도 에러
- 몇번의 이도을 할 것인지 사용자 입력 받기
  - 예외처리 : 숫자인지 아닌지
- 0~9까지 무작위 수를 생성하는 기능
- 각 Car가 한 이동마다 생성된 무작위 수가 4 이상인 경우에 이동하는 기능
- 각 이동마다 결과르 출력하는 기능
- 우승자를 출력하는 가능(여러명의 경우 ,(쉼표)로 구분)  
<br>

--------
## 구현 후 정리
<br>
### 클래스 및 퍼블릭 인터페이스
- Application : 어플리케이션 실행 <br>
- RacingController : Player에게서 Car의 이름과, move 횟수를 입력 받고 경기 시작
  - void start() : 결기 시작 <br>
- Player : 사용자의 입력을 받고 validation 후 반환하는 역할
  - List<String> enterCarsName() : 자동차 이름 List를 반환
  - int enterMoveNum() : move 횟수를 반환 <br>
- InputView : 사용자의 입력
  - String getInput()<br>
- Validator : util 클래스 입력으 validation 후 invalid하면 IllegalArgumentException 던짐
  - void isLengthOverFive(String input) : 이름이 5글자를 초과할 때 에러
  - void isNullInput(String input) : 이름이 비었으면 에러
  - void isNumber(String input) : 입력값이 숫자 아니면 에러 <br>
- Racing : 경기를 관장하는 클래스
  - void startRacing() : 주어진 횟수만큼 결기 <br>
- RandomNumberGenerator : 난수생성기
  - int generateRandomNumber() : 난수 생성 <br>
- Car : 차의 이름, 위치를 포함하고 있는 객체 클래스
  - int currentPosition() : 현재 위치 반환
  - String getName() : 이름 반환
  - void moveAhead() : 차의 위치 한칸 이동
  - void printCurrentPosition() : 현재 위 표시 (형식 : name : ----)
  - boolean isWinner(int maxPosition) : 우승자의 위치를 입력받아 우승자인지 아닌지 반환
- ErrorMessage : 주요한 에러 메세지르 담아놓은 상수 클래스


