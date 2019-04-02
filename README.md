자동차 경주 게임
=================



기능요구
---------
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9사이에서 random값을 구한후 random 값이 4 이상일 경우 전진하고, 3 이
하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

기능 프리뷰
-------------
### Class Index
* 인덱스 - 실제로 게임이 진행되는 메인 메소드를 가지는 클래스


### Class Car
* 자동차 - 자동차 인스턴스를 생성하기 위한 클래스
    * Method :
      * String getName() -> 생성된 인스턴스의 이름을 리턴하는 함수
      * int getPosition() -> 생성된 인스턴스의 위치를 리턴하는 함수
      * int movePosition() -> 생성된 인스턴스의 위치를 이동시키는 함수
    * Variable :
             * private final String name -> 생성된 인스턴스의 이름 (상수)
             * private int position -> 생성된 인스턴스의 위치(초기값은 0)


### Class Config
* 기능 - 게임에 필요한 메소드를 담아두는 클래스
    * Method :
      * String characterMultiple(char value, int count) -> char타입의 문자를 count만큼 리턴하는 함수
      * Boolean checkNameNumber(String[] nameArray) -> 입력받을 자동차 이름 수가 조건에 만족하는지 확인하는 함수
      * int findMaxPosition(Car[] garage) -> 가장 멀리 간 위치를 찾는 함수
      * String inputCarsName() -> 자동차의 이름을 받아 리턴하는 함수
      * String[] loopIfNotOneToFive(String[] carsArray) -> 자동차 이름이 1이상 5이하가 아닐 경우 반복하는 함수
      * String[] makeArrayByString(String name) -> 문자열을 ,를 기준으로 배열로 만드는 함수
      * String[] divideCarNameArray(String name) -> 조건에 만족할 시 자동차의 이름을 배열로 나눠 리턴하는 함수
      * Car[] makeGarage(String[] carArrays) -> Car인스턴스를 담은 배열을 생성
      * int makeRandom() -> 랜덤 값을 생성
      * void printRaceRelay(Car[] garage, int i) -> 레이스 상황을 중계(출력)하는 함수
      * String printWinner(Car[] garage) -> 승리자들을 형식에 맞춰 출력하는 함수
      * Car[] race(Car[] garage) -> 0.4이상일 경우 전진하는 레이스를 진행하는 함수
    * Variable :
       * final int LIMIT_TOP_NAME_NUMBER -> 받을 이름의 최대값
       * final int LIMIT_LOW_NAME_NUMBER -> 받을 이름의 최소값
기능 단위 Commit 체크
-----------------------
- [x] 1. 마크다운 작성 & Index클래스와 test폴더에 테스트코드 클래스 생성
- [x] 2. 자동차의 이름 출력
- [x] 3. 입력 받은 이름을 쉼표를 기준으로 분리하기
- [x] 4. 이름이 5자 이하인지 체크하기
- [x] 5. 입력 받은 이름만큼 인스턴스를 담은 배열 생성하기
- [x] 6. 랜덤한 수 생성하기
- [x] 7. 자동차의 이동한 위치 출력하기
- [x] 8. 자동차를 전진시키기
- [x] 9. N회 만큼 랜덤한 수를 생성하여 조건에 따라 전진시키기
- [x] 10. 우승자 출력시키기
- [x] 11. 5자 이상일 때 반복하기
- [x] 12. race 중계 출력하기
- [x] 13. main 구성하기
