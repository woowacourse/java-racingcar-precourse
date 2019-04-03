# [우아한 테크코스 2주차 미] 자동차 경주 게임

### 기능 목록 정의
1. 경주할 자동차들의 이름을 받아서 "," 로 구분한다.
    - 제한 사항 : 이름은 5자가 넘지 않도록 한다.
2. 받은 이름으로 Car 객체를 생성한다.
3. 게임이 실행될 횟수를 입력한다.
4. 각 자동차에 랜덤한 숫자를 받는다.
5. 랜덤한 숫자가 4 이상이면 전진, 3 이하면 상태 변화 없음을 "-"를 이용해 나타낸다.
6. 실행 결과를 출력한다.
7. 최종 우승자의 이름을 출력한다.

### 제한 사항
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- else 예약어를 쓰지 않는다.


### 메소드 설명
- public void run() : 로직을 실행시키는 메소드
- private boolean checkFiveWords(String[] carNameList) : ","로 구분된 이름이 5자인지 체크하는 메소드
- private String[] inputCarNames() : 자동차 이름을 입력 받아 ","로 구분하는 메소드
- private List<Car> getCarList(String[] carNameList) : 생성자를 이용해 Car 객체를 list에 add하는 메소드
- private int getRoundCount() : 게임을 돌릴 횟수를 입력 받는 메소드
- private int getRandomNumber() : 게임 도중 필요한 랜덤한 숫자를 주는 메소드
- private void runOneRound(List<Car> carList) : 한번의 게임 실행 결과를 판별해주는 메소드
- private String getHyphen(int position) : 게임 위치를 알려줄 "-"을 주는 메소드 
- private void printResult(List<Car> carList) : 결과를 출력해 주는 메소드
- private int getPositionMax(List<Car> carList) : 포지션의 최고값을 리턴해 주는 메소드
- private List<String> getWinnerName(List<Car> carList) : 우승자의 이름을 리스트에 add해주고 우승자 이름 리스트를 리턴해주는 메소드
- private void printWinnerName(List<Car> carList) : 우승 시 결과를 출력해주는 메소드
 