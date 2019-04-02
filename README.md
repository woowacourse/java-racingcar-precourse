## Java Racing Car

**자동차 경주 게임**을 제작하고자 한다!<br>
각 `자동차` 마다 달릴 수 있는 상황이 다른데, 이에 따라서 **경주 결과**가 결정된다.<br>
만약, `자동차`가 재수없게도 바퀴가 펑크나면 **교체**해야되므로 *해당 시간* 에 달리지 못할 수도 있다.<br>

* 대기중인 자동차
><p>
><img src="https://user-images.githubusercontent.com/34855745/55380612-a62f1880-555b-11e9-8b2c-b52748cf1410.JPG" width="800" height="300"/>
></p>
주어지는 **자동차 경주 게임**에서 누가 `우승`했는지 알려주는 프로그램을 만들자!<br>
단, `우승자`는 한 명 이상일 수 있다!<br>

### 구현한 클래스
* Car Class : `자동차의 정보`를 가지고 있는 클래스
* CarManager Class : 자동차의 정보들을 `리스트로 관리`해주는 클래스
* Racing Class : 자동차의 `경주가 진행`되는 클래스
* Play Class : 자동차 경주대회를 `실행`할 클래스

### 클래스별 구현 메서드
#### [Car Class]
* go : 자동차가 `전진`하는 메서드
* toString : 자동차의 이름과 현재 위치에 대한 `정보`를 String으로 나타내주는 메서드(오버라이딩)
* getPosition : 자동차의 `현재 위치`를 얻어오는 메서드
* getName : 자동차의 `이름`을 얻어오는 메서드

#### [CarManager Class]
* addNames : 자동차 이름들의 정보를 입력받아 자동차 `리스트에 저장`하는 메서드
* makeRandom : 0 ~ 9 까지 `random값`을 추출할 메서드
* goOrStop : 각각의 자동차에 대하여 전진할 것인지 멈춰 있을것인지 `결정`하는 메서드
* printCarList : 자동차의 `이름`과 현재 `상태`를 출력할 메서드
* findFristPositionNumber : `1등 자동차의 위치`를 알아오는 메서드
* whoIsFirst : 자동차 목록 중에서 `1등 자동차들의 이름`을 얻어오는 메서드

#### [Racing Class]
* raceBegin : 자동차 경주를 준비, 진행, 결과, 종료 에 대한 `전체적인 과정`이 실행되는 메서드
* enterUsers : 자동차의 `이름을 입력`받는 메서드
* enterRaceTime : 경주의 `진행 횟수를 입력`받는 메서드
* startRace : 자동차 경주가 `진행`되는 메서드
* raceResult : 자동차 경주의 `결과`를 콘솔에 출력하는 메서드
* raceEnd : 자동차의 경주가 끝난 뒤 `정리`하는 메서드
* isValidUsers : 입력받은 `유저의 정보가 유효`한지 판별하는 메서드
* isValidTime : 입력받은 `진행 횟수가 적합`한지 판별하는 메서드
* timeWaitForResult : 박진감 있는 경기 진행을 위해, 한 단계씩 출력하기 위한 `대기 시간`을 만드는 메서드

#### [Play Class]
> **자동차의 경주**가 시작된다!!
