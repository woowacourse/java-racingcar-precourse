# 레이싱 경주 게임
## 기능
    * 주어진 횟수 동안 n대의 자동차는 랜덤 값에 의해 움직인다.
    * 쉼표로 구분하여, 글자는 5글자를 넘지 않는다.
    * 랜덤 값으로 4이상이면 go / 3이하면 stop

## 참고
    * Car 객체 활용하기, 기본 생성자는 없다.
    * Car에서의 변수는 private이다.
    * setter는 가능하면 사용하지 않는다.
    * 자바 코드 컨벤션을 지킨다.
    * 들여쓰기는 3이 넘지 않아야 한다.
    * 각각의 함수는 15라인을 넘지 않는다.
    * else 예약어를 쓰지 않는다.

## 클래스
### Car : 자동차 각각의 정보를 나타낸다.
* 변수
    * name(String) : 차의 이름을 나타낸다.
    * position(int) : 차의 위치를 나타낸다.
* 생성자
    * Car(String name) : 매개 변수가 5글자를 넘지는 않는지 체크한다.
* 메소드
    * printCarPosition(void) : 매개 변수에 따라 이동하며, 이동한 거리를 출력한다.
    * collectMaxPosition(int) : 가장 멀리 이동한 자동차의 거리를 반환한다.
    * isVictoryCar(boolean) : 우승자를 찾아서 출력하며, 여러명일 경우 콤마(,)를 찍는다.

### RacingCar : 메인 클래스입니다.
* 메소드
    * gameStart(void) : 게임을 진행한다.
    * getCarsName(String) : 전체 차의 이름을 한 줄로 입력받고 그대로 반환한다.
    * getMaxTryCount(int) : 전체 시도하는 횟수를 입력받고 그대로 반환한다.(0보다 작을 경우 종료)

### RacingCarGame : 게임에 필요한 기능들을 수행합니다.
* 변수
    * cars[](Car) : 각각의 자동차를 객체 배열로 만든다.
    * maxPosition(int) : 우승자의 최대 이동 거리를 담는다.
* 생성자
    * RacingCarGame(String cars) : 자동차 등록하는 메소드를 실행시킨다.
* 메소드
    * registerCar(void) : 생성자에서 실행되어 자동차를 각각 등록한다.
    * startRacingGame(void) : 자동차 전체를 1회 움직인다.
    * isMovePosition(boolean) :  랜덤 값을 생성하고 4이상 true, 3이하 false를 반환한다.
    * setMaxPosition(void) : 자동차 전체 중에서 가장 멀리 이동한 거리를 저장한다.
    * printVictoryCar(void) : 누가 최종 우승을 했는지 모두 출력한다.
