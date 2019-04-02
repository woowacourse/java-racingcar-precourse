# 2주차 미션 - 자동차 경주 게임

## 기능 요구사항
  - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  - 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3이하의 값이면 멈춘다.
  - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
  
## 기능 목록

### Car class
  - 자동차의 이름, 위치, 자동차의 주행(난수생성, 현재까지 달려온 거리 출력)을 관리하는 클래스
  
#### member
  - name, position
  - name은 final 변수 생성자로 한번 만 지정 할 수 있다.
  
#### method
  - randomValueCreate : 1~9까지 난수 생성
  - acceleratorAndbreak : 전진and멈춤에 따란 위치변화
  - printDistance : 현재까지 달려온 거리를 출력
  - getName
  - getPosition
  
### Gamemodule class
  - 게임을 운영하는데 있어 필요한 정보와 기능을 관리하는 클래스
  
#### member
  - carlist : 자동차들을 저장하고 있는 리스트
  - inputCarname, inputRound, winnerPoint
  
#### method
  - initSetup : 게임가이드 메세지 출력, inputCarname, inputRoundturn, createCar  
  - inputCarname : 자동차의 이름을 입력 받고, 5자리 이하인지에 대한 예외 처리
  - inputRoundturn : 시도 횟수를 입력 받고, 정수 아닌 값을 예외 처리
  - createCar : 자동차 생성
  - racing : 레이싱
  - checkWinner : 우승자 검사

### Playgame class 
  - 게임시작
  - 입력받은 시도 횟수 만큼 레이싱 실행
