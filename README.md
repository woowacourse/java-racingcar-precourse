# 우아한테크코스 3기 프리코스 - 자동차 경주 게임

## 💻 기능 구현 목록

#### :flags: 경주 시작 전


- [x] 사용자로부터 경주에 참여할 자동차 이름을 받고, 쉼표 단위로 나눈다.
  - [x] 예외: 공백입력
  - [x] 예외: 이름이 5글자를 넘어가는 개체가 있는 경우
  - [x] 예외: 이름이 중복되는 경우
  - [x] 예외: 하나만 입력하는 경우
- [x] 입력 값에 따라 자동차를 생성한다.
- [x] 사용자로부터 시도 회수를 입력받는다.
  - [x] 예외: 숫자가 아니거나 실수형식으로 입력한 경우
  - [x] 예외: 지나치게 큰 값(int 범위 초과)을 입력한 경우
  - [x] 예외: 0이하를 입력한 경우
  - [x] 예외: 공백 입력
- [x] *모든 예외는 [ERROR]로 시작하는 문구와 함께 출력한다.

#### :car: 게임 중
- [x] 사용자가 입력한 시도 회수만큼의 회차(Turn)가 진행된다.
  - [x] 각 회차마다 자동차별로 난수를 생성해 4이상이면 전진, 이하면 움직이지 않는다. *RandomUtils를 이용한다.
  - [x] 각 회차마다 자동차 이름과 위치를 출력한다.
- [x] 모든 회차가 끝난 후 승자를 출력한다.
------------
## :newspaper: Update Log. Updated 2020.12.08.
### :scroll: 프로젝트 구조 및 클래스 설명

```
raicingcar ── Application.java
           │
           ├─ controller ─── RaicingCarGame.java
           │
           ├─   domain   ─┬─ Car.java
           │              ├  CarDTO.java 
           │              ├  Cars.java 
           │              ├  DecisionMaker.java
           │              ├  Turn.java
           │              └  Winners.java
           │
           └     view    ─┬─ InputView.java
                          └  OutputView.java
```
----------------------
##### Application
- 프로그램 실행 전, 한 번의 게임을 위해 필요한 객체들을 생성하고 게임을 생성합니다.

----------------------
### controller 패키지


##### RaicingCarGame
- 게임 진행 중 전반적인 로직을 담당하는 Controller입니다.

----------------------
### domain 패키지


##### Car
- 자동차 클래스입니다.
- 사용자입력으로부터 생성 검증 로직을 가집니다.
- *move()* 메소드를 통해 자신의 *position*을 변화시킵니다.

##### Cars
- *Car* 객체들을 가지는 일급컬렉션입니다.
- 사용자입력으로부터 생성 검증 로직을 가집니다.
- *Car* 객체들에게 일괄적으로 (확률적으로)전진하라는 메시지를 전달합니다.

##### CarDTO
- 레이어간 정보 전송을 위한 DTO클래스입니다.
- 필요 최소한의 정보와 메소드를 담습니다.

##### DecisionMaker
- *Car* 객체는 확률적으로 움직이는데, 이 때 *Car* 객체는 전진 여부를 판단하는 로직을 *DecisionMaker*에 위임합니다.

##### Turn
- 게임 회차(시도 회수)만큼 게임이 진행되도록 관리하는 클래스입니다.
- 사용자입력으로부터 생성 검증 로직을 가집니다.

##### Winners
- 우승자들을 가려냅니다.

----------------------
### view패키지


##### InputView
- 입력과 출력이 섞인 UI 로직을 담당합니다.
- 공백 입력과 같은 비교적 가벼운 예외 처리를 담당합니다.

##### OutputView
- 출력 로직을 담당합니다.

----------------------

### :alarm_clock: 프로그램 Flow

![KakaoTalk_20201208_223741480](https://user-images.githubusercontent.com/49346677/101490990-80038200-39a6-11eb-839b-1914795c4bf5.png)

- 게임이 시작되기 전, 유저로부터 적합한 자동차 이름 목록과 시도 회수를 받습니다.
- 각각의 객체들이 생성 과정에서 자신에게 적합한 값이 넘어왔는지 스스로 검증을 합니다.
- 객체들이 문제없이 생성된 경우, *Application*은 이 객체들을 *RaicingCarGame*으로 넘겨주며 게임을 실행토록 합니다.

![KakaoTalk_20201208_225011968](https://user-images.githubusercontent.com/49346677/101492022-c5747f00-39a7-11eb-97fb-6e4acc413c82.png)

- 게임이 시작되고 난 후에 Controller 객체 *RaicingCarGame*은 *Turn*과 진행 상태를 주고 받으며 계속 진행할지를 판단합니다.
- 진행중인 과정에서 *RaicingCarGame*은 *Cars*에게 매 회차마다 자동차들을 전진시키라는 메시지를 넘깁니다.
- *Cars*는 *Car*객체들에게 일괄적으로 전진 메시지를 넘깁니다.
- *Car*는 각각 *Decision Maker*에게 난수에 의한 전진 판단 여부를 위임, 판단 여부에 따라 전진하고 상태를 변화시킵니다.
- *View* Layer까지 데이터를 전송하기 위해 *Cars*로부터 *CarDTO* 목록들을 받습니다. 이 때, *Car* 객체는 스스로 DTO 객체로 변환한 객체를 *Cars*에게 넘겨줍니다.
- *View*는 *CarDTO* 목록들을 받아 출력합니다.

![KakaoTalk_20201208_223835461](https://user-images.githubusercontent.com/49346677/101490995-8134af00-39a6-11eb-93d1-dd63101a93c2.png)

- *Turn* 객체에서 종료 값이 넘어오면 *RaicingCarGame*은 *Winners*에게 *Cars*객체를 넘깁니다.
- *Winners*는 *Cars*에서 우승자를 추려 *Winners* 객체를 생성합니다.
- 이후 *RaicingCarGame*는 *Winners*에게 우승자 명단을 받아와 *View*에게 넘겨주어 우승자 명단 출력을 요청합니다.

---------------------------------
작성자 : 김기문(Kimun Kim, TributeToTheMoon)
