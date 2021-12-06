# 미션 - 자동차 경주 게임

## 👩🏻‍💻 구현할 기능 목록

### Car
- 랜덤 값 생성
- position 변경
- 차 이름 반환
- 차 position 반

### User
- 차 이름 입력
  - IllegalArgumentException
    - 이름에 공백이 존재하는 경우
    - 이름이 1~5이 아닌 경우
    - 중복된 이름
- 총 시도 횟수 입력
  - IllegalArgumentException
    - 숫자가 아닌 경우(실수 포함)
    - 음수인 경우
- 시도 횟수 정수 타입으로 저장
- 문장으로 입력받은 차 이름을 배열에 넣어 반환
- 총 시도할 횟수 반환
- 차 이름 배열 반

### Game
- n개의 car 객체 생성
- 경주 진행 (한 라운드)
- 라운드 별 결과 출력
- 가장 앞에 있는 차의 Position 구하기 (비교를 위함)
- 우승자 이름 반환

### CarNameException
- 차 이름의 글자 수가 1~5이 아닌 경우
- 중복되는 경우
- 이름에 공백이 존재하는 경우

### RoundTimesException
- 숫자가 아닌 경우
- 음수인 경우

### Application (main)
차례대로 경기 진행
