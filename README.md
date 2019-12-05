# 자동차 경주

## 클래스

- Car.java: 경주에 참여할 자동차를 생성
- Stadium.java: 사용자의 입력을 받아 자동차를 생성하고 경주를 진행
- Main.java: Stadium의 runRacingCar 실행

## 구현할 기능 목록

1. **경주할 자동차 이름 입력**
    - n개까지 입력 가능
    - 이름은 5자 이하만 가능
        - [예외 처리] 이름이 없거나 5자 초과인 경우
    - 쉼표로 구분
        - [예외 처리] 쉼표가 아닌 경우
        
2. **시도할 횟수 입력**
    - 숫자만 입력 가능
        - [예외 처리] 숫자가 아닌 경우
        - [예외 처리] 최대값도 정해야할듯 (ex. 20)

3. **자동차 경주 시작**
    - 각 자동차 별로 0~9까지 랜덤 값을 구한다.
    - 결과값이 4이상일 경우 전진한다.
    - 움직인 결과를 출력할 때 차량의 이름도 함께 출력한다.
        - 움직인 거리 출력: '-' 기호로 표시
        - 차량의 이름 출력
    - 입력한 횟수만큼 경주가 완료되면 게임을 종료한다.
        - 우승한 차량의 이름을 출력한다. (우승자는 1명 이상일 수 있다.)
