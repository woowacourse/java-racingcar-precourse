# 미션 - 자동차 경주 게임

## 구현할 기능 목록

-자동차 이름 문자열을 받아 파싱하는 기능

-이동 시도 횟수 받아서 게임을 세팅하는 기능

-정해진 횟수만큼 게임 진행하는 기능

-랜덤 값을 통해 전진여부 결정하는 기능

-매 라운드 종료 시 현재 상태를 출력하는 기능

-완료 후 우승자를 결정해서 출력하는 기능


## 예외 처리 사항

-자동차 이름이 5자를 초과하는 경우

-시도 횟수가 숫자가 아닌 경우


## 파일 목록

### main.java.racingcar

Application.java: 어플리케이션 실행 (main method 위치)

Board.java: 게임 진행 상태 및 최종 결과 출력

Car.java: 자동차 객체의 정보 저장

Game.java: 숫자야구 게임 진행

Referee.java: 전진 여부 및 우승자 결정

StringParser.java: 입력받은 문자열 파싱

Validator.java: 플레이어의 입력이 유효한지 검증

SystemMessage.java: 콘솔창에 출력되는 메시지를 모아놓은 클래스

### test.java.racingcar

ApplicationTest.java: 어플리케이션 테스트
