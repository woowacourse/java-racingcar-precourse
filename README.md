# #2 자동차 경주 게임

## 요구 사항
* 자바 코드 컨벤션 준수
* indent(들여쓰기)가 3이 넘지 않도록 구현
* 메소드의 길이가 15라인을 넘어가지 않도록 구현
* else 예약어를 쓰지 않는다.

## 구현해야할 기능들
1. Main.java 생성

2. Car 객체 기능 만들기
    * Comparable을 이용한 position 기준 내림차순 정렬
    * position 출력 기능(getPosition)
    * Name 출력 기능(getName)
    * Random 숫자 생성부터 출력 기능까지 실행 해주는 기능(runOneCycle)
    * 0 ~ 9의 Random 숫자 생성 기능(createRandomDistance)
    * 만들어진 Random 숫자가 4 이상인지 검사하는 기능(isLagerThanFour)
    * 전진 기능(movePosition)
    * Car 인스턴스의 현재 위치 출력 기능(printCurrentPosition)

3. 자동차 경주 게임 기능(RacingCarGame)
    * 메인 게임 기능(gameStart)
    * 사용자에게 자동차의 이름을 요청 기능(requestCarName)
        * ',' 기준으로 split을 진행하고 trim을 이용해 공백을 제거하는 기능(splitCarName)
        * 길이 제한은 5자(isLessThanFive)
    * 자동차 생성 기능(createCar)
    * 사용자에게 시도할 횟수를 입력 받음(requestRound)
        * NumberFormatException을 이용해 숫자 여부를 체크하는 것이 좋을 듯!
    * 입력 받은 횟수 만큼 반복문을 실행하는 기능(implementRound)
    * 1위 출력 기능(printFristRank)


