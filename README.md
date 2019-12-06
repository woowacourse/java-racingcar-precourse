프리코스 2주차 - 자동차 경주 게임
==============================
구현 기능 목록
-------------
### 1. Car class
* 전진 기능
    * 전진하는 조건을 만족하는지 판단하는 함수
* 현재 위치를 알려주는 기능
    * public int getPosition();
* 이름을 알려주는 기능
    * public String getName();
### 2. Game class
* 게임에 참여하는 자동차 이름을 입력받는 기능
    * 입력받은 String을 parsing해 Car[]에 추가
* 시도할 횟수 입력받는 기능
* 게임을 진행하는 기능(1회)
    * 게임을 진행할 때마다 결과를 출력하는 기능
* 게임 우승자를 출력하는 기능
* 전체적인 게임 플로우를 관리하는 기능
    * public static void initGames();
### 3. Main class
* static 변수로 Game class를 선언 후 게임 실행