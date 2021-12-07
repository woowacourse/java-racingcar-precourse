# 자동차 경주 게임

## 객체

### Car

- Name
- Position

**기능**

- canMove()
    - 0~9의 무작위 값이 4 이상인지 확인한다
- move()
    - canMove() == true이면 한칸 앞으로 움직인다
- getPosition()
- getName()

### Umpire

- carList : 경주에 참여하는 차들
- winners : 승자들

**기능**

- getWinner(List<Car> carList)
    - 해당 Car의 이름리스트 반환
- findMaxPositions()
- findSamePosition()
- getWinnerNameList()

## Game

- public int num;
- public List<Car> carList;
- public Umpire umpire;
- public Input input;
- public Output output;

**기능**

- start()
    - 주어진 숫자 만큼 게임을 플레이한다
- end()
    - 게임이 끝나고 결과를 보여준다

**Input ,Output**

- 주어진 조건에따라 입,출력한다

## 제한사항

- 게임 시도하려는 숫자는 양수만 가능하다
- 이름은 무조건 입력해야한다
- 이름은 쉼표를 기준으로 구분
- 이름의 길이는 1~5자만 가능하다
- 우승자는 한 명 이상일 수 있다.
- 우승자는 쉼표를 이용하여 구분한다
- 잘못된 값이 일어날 경우
    - IllegalArgumentException 발생시킴
    - [ERROR]로 시작하는 에러 메세지 출력
    - 그 부분부터 입력 다시 받기




