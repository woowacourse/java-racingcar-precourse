# WEEK2 자동차 경주게임

##프로그래밍 요구사항
*자바코드 컨벤션 준수
*indent 2이하
*함수 길이 15라인 이하
*else 쓰지 않을 것
    **값 return으로 구현
    **switch/case도 허용 안함

##기능 요구사항
*Main class
    **프로그램 실행

*RacingGame
    **InitCarName
        - 경주할 자동차 입력받음
        - "," 로 사용자 구분
    **isValid
        - 자동차 이름 유효성 판단
    **Game
        - 게임 실행
        - Car 클래스의 함수 호출
    **EndGame
        - 최종 출력 후 프로그램 종료

*CAR class
    **RandomMove
        - 0에서 9까지 랜덤으로 값을 지정한다
        - 4이상일 경우 전진
        - 3이하일 경우 그대로 머문다.
    **printMove
        - 이동 거리를 "-"로 출력한다.
    **FindWinner
        - 우승자를 찾는다
    **PrintUser
        - 자동차 이름을 출력한다.