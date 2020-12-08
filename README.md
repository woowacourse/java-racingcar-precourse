# 미션 - 자동차 경주 게임

## 기능 구현 진행 과정
- [x] 경주할 자동차 이름 입력 받기
    - [x] "," 기준으로 입력된 이름 나누기
    - [x] 각각의 이름 입력이 5글자인지 확인하기
    - [x] 중복된 이름 확인하기
    - [x] 참가자 인원수 확인하기

- [x] 시도 횟수 입력받기
    - [x] 입력 값이 숫자인지 확인

- [x] 자동차 경주 진행
    - [x] 참가자 2명 이상인지 확인
    - [x] 시도 횟수만큼 반복
    - [x] 랜덤 숫자를 활용하여 차량 이동
    - [x] 매번 라운드 상황 표시
    - [x] 최종라운드 종료 후 승자 표시
        - [x] 우승자가 1명인 경우
        - [x] 우승자가 여러명인 경우

- [x] 추가사항
    - [x] 예외 상황인 경우, "[ERROR]" 를 추가한 메세지 제공

## Car
- getCarName() : 차량 이름 getter
- getCarPosition() : 차량 위치 getter
- moveCar() : 조건에 따른 차량 position 변경
- printCarPosition() : 차량 이름과 차량 위치를 출력

## Race
- startRace() : 참가차량 명단, 시도횟수 정의
    - inputParticipationCar() : 참가 차량 입력 및 리스트 생성
    - inputTimes() : 시도횟수 입력
- runRace() : 시도횟수 만큼 반복 진행
- printWinnerList() : 최종 우승자 출력
    - findMaxPosition() : 차량들 중 가장 먼 위치 확인
- checkParticipationCars() : 참가 인원 확인

## InputExceptionController
- checkInputCars() : 차량 입력 확인
    - isDuplication() : 중복의 경우 예외 발생
    - isLengthExcess() : 이름이 짧을 경우 예외 발생

- checkParticipation() : 참가 인원 확인
    - isParticipationLess() : 참가인원이 1명일 경우 예외 발생