# 미션 - 자동차 경주 게임
우아한테크코스 프리코스 2주차 미션입니다.

## ⭐ 구현할 기능 목록 
- Car
    - 전진하기 기능
        - 0에서 9사이의 랜덤 값 중, 4이상이면 전진한다.
    - 정렬 기능 ( compareTo 오버라이드 )
    - position이 같은지 비교하는 기능
    - 이름을 리턴해주는 기능
    - 현재 position을 리턴해주는 기능
- Cars
    - 생정자를 통해 Car 객체들 생성
        - CarValidator를 이용해 유효성 검증
    - 레이싱을 진행하며, 결과를 출력하는 기능
    - 가장 빠른 자동차를 리턴해주는 기능         
- Round
    - 생정자를 통해 시도 횟수 등록
        - 입력 값이 숫자인지 아닌지 검증 
    - 시도 횟수 리턴 기능
- RacingCarGame
    - 게임 시작 기능
        - 게임 초기화 기능 
        - 시도할 회수(Round) 만큼 게임 게임 실행하는 기능
        - 우승자 출력 기능
- CarValidator
    - 이름은 시스템에 설정 된 구분 문자로 구분하며, 입력 값에 대한 에러는 아래와 같다.
        - 입력 값이 없는 경우 : SpaceInputException
        - 구분 기호가 엾는 경우 : WithoutDelimiterException
        - 이름 입력이 유효하지 않는 에러 : InvalidNameLengthException    
        - 중복 이름이 있는 경우 : NameDuplicationException
        - 구분 문자만 입력하고, 이름은 입력하지 않은 경우 : InputWithoutNameException
    
