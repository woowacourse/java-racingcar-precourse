# 미션 - 자동차 경주 게임

## 구현할 기능 목록

> 📌 을 사용한 기능은 요구사항에는 없지만 개인적으로 있어야 한다고 생각하는 기능이라 추가했습니다.
> 테스트 코드 등에서 문제가 발생하면 제거할 수도 있는 기능입니다.

- 게임 실행
  - 'Application' 실행 시 콘솔 창 실행
  - 입력 값
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
  - 게임 안내 멘트
    - 게임 시작 직후
      - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
    - 자동차 이름 입력 이후
      - "시도할 회수는 몇회인가요?" 출력
    - 시도 횟수 입력 이후
      - 한줄 공백
      - "실행 결과" 한줄 출력
      - 이후 자동차의 수만큼 출력
        - ex. "pobi : -"
    - 횟수만큼 시도한 이후
      - 한줄 공백
      - 최종 우승자 출력
        - ex. "최종 우승자 : pobi, jun"
  - 전진 혹은 멈춤
    - 매 시도에 자동차마다 각각의 난수 생성
    - 난수가 4보다 작으면 멈춤
    - 난수가 4 이상이면 전진


- 한자리의 난수 생성
  - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 활용
  - 0 ~ 9 사이의 수여야 한다


- 예외 처리
  - 자동차 이름 입력
    - 공백 허용 X 👉 `IllegalArgumentException`
    - 5자보다 많은 자동차 이름 입력 👉 `IllegalArgumentException`
    - 📌 문자 및 숫자는 허용
    - 📌 쉼표 외의 특수문자 입력 시 👉 `IllegalArgumentException`
    - 📌 중복되는 자동차 이름 입력 시 👉 `IllegalArgumentException`


- 주의점
  - 공백 및 한줄 공백
