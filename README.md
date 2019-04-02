# #2 자동차 경주 게임

## 요구 사항
* 자바 코드 컨벤션 준수
* indent(들여쓰기)가 3이 넘지 않도록 구현
* 메소드의 길이가 15라인을 넘어가지 않도록 구현
* else 예약어를 쓰지 않는다.

## 구현 클래스
해당 게임에서는 다음과 같은 클래스를 구현한다.
1. Main - 게임을 실행시킬 메인 클래스이다.
1. Car - 자동차 인스턴스를 생성하고 이동 및 출력의 기능의 클래스 이다.
1. RacingCarGame - 자동차 이름, 횟수를 입력 받고 1위를 출력해주는 클래스이다.

## 구현해야할 기능들
1. Main.java 생성

1. Car 이동 및 출력 기능
    * Random 숫자 생성부터 출력 기능까지 실행 해주는 메소드(runOneCycle) -> Car
    * 0 ~ 9의 Random 숫자 생성 메소드(createRandomDistance) -> Car
    * 만들어진 Random 숫자가 4 이상인지 검사하는 메소드(lagerThanFour) -> Car
    * 전진 메소드(movePosition) -> Car
    * Car 인스턴스의 현재 위치 출력 메소드(printCurrentPosition) -> RacingCarGame

1. 사용자에게 입력을 받고 자동차를 생성하는 기능
    * 메인 게임 메소드(gameStart) -> RacingCarGame
    * 사용자에게 자동차의 이름을 요청 메소드(requestCarName) -> RacingCarGame
        * ',' 기준으로 split을 진행하는 메소드(splitCarName) -> RacingCarGame
        * split한 문자 배열을 trim을 이용해 공백을 제거하는 메소드(trimCarName) -> RacingCarGame
        * trim 후 문자열의 길이가 0인게 있는지 확인하는 메소드(lagerThanZero) -> RacingCarGame
        * 길이 제한 5자 메소드(lessThanFive) -> RacingCarGame
    * 자동차 생성 메소드(createCar) -> RacingCarGame
    
1. 사용자에게 시도 횟수 입력 받고 게임을 진행 기능
    * 사용자에게 시도할 횟수를 입력 받음(requestRound) -> RacingCarGame
        * NumberFormatException을 이용해 숫자 여부를 체크하는 것이 좋을 듯(checkNumberException)!
    * 입력 받은 횟수 만큼 반복문을 실행하는 기능(implementRound) -> RacingCarGame
    
1. 1위를 나타내 주는 기능
    * Comparable을 이용한 position 기준 내림차순 정렬 -> Car
    * 1위 출력 기능(printWinner) -> RacingCarGame




