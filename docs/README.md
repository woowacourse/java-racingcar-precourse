## 클래스 목록
도메인
- Car : 게임 진행의 주체인 자동차
- Coin : 게임의 횟수를 기록하며 게임이 진행중인지 나타낸다

컨트롤러
- GameMachine : 게임 진행상황을 기록하고 각 클래스들을 연결한다

뷰
- InputView : 유저에게 값을 입력받기 위한 내용을 출력하고, 해당하는 값을 입력받는다
- OutputView : 게임 진행상황을 출력한다

## 기능 구현 설계
! 에러를 발생시킬 경우 `[ERROR]` 를 포함한 메시지와 함께 `IllegalArgumentException`를 발생시켜야 한다

- [ ] 자동차 이름을 입력받는다 - `Gamamachine#getCarNames() => InputView#carNames()`
  - [ ] 자동차 이름은 ','를 기준으로 추출한다 - `InputView#extractCarNames()`
  - [ ] 입력받은 자동차 이름을 검증한다 - `InputView#validateCarNames()`
    - [ ] 이름이 없는 경우 에러와 함께 `[ERROR] 자동차 이름을 쉼표(,) 기준으로 구분하며 1글자 이상이어야 합니다` 메세지를 출력하고 그 부분부터 입력을 다시 받는다 - `InputView#validateCarNameExist()`
    - [ ] 이름이 5자를 넘으면 에러와 함께 `[ERROR] 자동차 이름은 5자를 넘길 수 없습니다` 메시지를 출력하고 그 부분부터 입력을 다시 받는다 - `InputView#validateCarNameLength()`
- [ ] 추출한 자동차 수를 기준으로 `Car` 인스턴스를 N개 생성한다 - `GameMachine#createCars()`
- [ ] 게임 실행할 횟수를 입력받는다 - `GameMachine#insertCoins => InputView#coins()`
    - [ ] 입력받은 값이 숫자가 아니라면 `[ERROR] 게임 실행할 횟수는 숫자만 입력받을 수 있습니다` 메시지를 출력하고 그 부분부터 입력을 다시 받는다 - `InputView#validateCoin()`
- [ ] 입력받은 횟수만큼 게임을 실행한다 - `GameMachine#play() => Car#move()`
  - [ ] 각 `Car` 인스턴스에 대해 0 ~ 9 사이에 존재하는 무작위 값을 생성하고 그 값이 4 이상일 경우 전진한다 - `Car#move()`
  - [ ] 매 게임 횟수 마다 각 `Car`가 얼만큼 전진했는지 `OutputView`에 나타낸다 - `GameMachine#play() => OutputView#move()`
  - [ ] `GameMachine`은 게임 횟수를 기록하며 입력받은 횟수 X만큼 수행했을 때 게임을 종료시킨다 - `GameMachine#isPlaying => Coin#isPlaying()`
- [ ] 가장 멀리 나간 자동차가 우승한다 - `GameMachine#judgeDistances() => Car#getDistance()`
  - [ ] 최종 우승자(복수 가능)를 `OutputView`에 나타낸다 - `GameMachine#printWinner() => OutputView#printWinner()`
