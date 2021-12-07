# 미션 - 자동차 경주 게임

## 📝 프로젝트 구조

- RacingCarGame
  - 게임 시작하기
  - 실행 결과 출력하기
  - 최종 우승자 출력하기
- RacingCarGameRule
  - RacingCarGame의 rule에 관련된 상수 모음
- RacingCarGameMessage
  - RacingCarGame의 message에 관련된 상수 모음
- User
  - 자동차 이름 입력 받기
  - 시도할 회수 입력 받기
- Check
  - 자동차 이름 입력 확인
    - (예외 처리)
    - 자동차 이름 개수가 int의 값을 벗어날 경우
    - 자동차 이름에 스페이스가 포함된 경우
    - 자동차 이름에 탭이 포함된 경우
    - 자동차 이름이 1자 미만이거나 5자 초과인 경우
    - 자동차 이름이 중복될 경우
  - 시도 횟수 입력 확인
    - (예외 처리)
    - 시도 횟수가 숫자가 아닌 값이 입력될 경우
    - 시도 횟수가 int의 값을 벗어날 경우
    - 시도 횟수가 0인 경우
- Car
  - 전진 또는 멈추기
  - 이름과 위치 상태 출력하기
- Referee
  - 우승자 판단하기
  - 우승자 이름 말하기

<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
