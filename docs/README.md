# 미션 - 자동차 경주 게임

## 📝 기능 목록

- 경주할 자동차 이름 입력받기
  - 쉼표(,)를 이용하여 구분하기
  - 예외가 발생할 경우 다시 입력 받기
  - 예외처리
    - 자동차 이름 개수가 int의 값을 벗어날 경우
    - 자동차 이름에 스페이스가 포함된 경우
    - 자동차 이름에 탭이 포함된 경우
    - 자동차 이름이 1자 미만이거나 5자 초과인 경우
    - 자동차 이름이 중복될 경우
- 시도할 회수 입력받기
  - 예외가 발생할 경우 다시 입력 받기
  - 예외처리
    - 숫자가 아닌 값이 입력될 경우
    - 시도 횟수가 int의 값을 벗어날 경우
    - 시도 횟수가 0인 경우
- 실행 결과 출력하기
  - 횟수 별로 실행 결과 출력하기
  - 각 자동차 별로 이름과 위치 출력하기
- 최종 우승자 출력하기
  - 가장 많이 이동한 자동차 이름 출력하기
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분하기

## 📁 프로젝트 구조
```
│  .editorconfig
│  naver-checkstyle-rules.xml
│  naver-intellij-formatter.xml
│  README.md
└─src
    ├─main
    │  └─java
    │      ├─constant
    │      │      RacingCarGameMessage.java
    │      │      RacingCarGameRule.java
    │      │
    │      └─racingcar
    │              Application.java
    │              Car.java
    │              Checker.java
    │              RacingCarGame.java
    │              Referee.java
    │              User.java
    │
    └─test
        └─java
            └─racingcar
                    ApplicationTest.java
```

## 📋 클래스 역할

- RacingCarGame
  - 게임 시작하기
  - 실행 결과 출력하기
  - 최종 우승자 출력하기
- User
  - 자동차 이름 입력 받기
  - 시도 횟수 입력 받기
- Checker
  - 자동차 이름 입력 검사 하기
  - 시도 횟수 입력 검사 하기
- Car
  - 전진 또는 멈추기
  - 이름과 위치 출력하기
- Referee
  - 우승자 판단하기
  - 우승자 이름 말하기
- RacingCarGameRule
  - RacingCarGame의 rule에 관련된 상수 모음
- RacingCarGameMessage
  - RacingCarGame의 message에 관련된 상수 모음

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
