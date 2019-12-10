# 기능구현목록
- 게임이 시작하면 게임에 사용될 자동차 이름을 입력받는다. 
    1. 문자열을 구분자 ","으로 구분하여 각각의 자동차 이름을 구한다
    2. 자동차의 이름은 5자 이하로 하고 이를 어길 경우 경고문을 출력한 후 다시 입력받는다.
- 게임에 사용될 이동의 횟수를 입력받는다. 
    1. 입력되는 숫자는 0이 아닌 자연수로 하고 이를 어길 경우 경고문을 출력한 후 다시 입력받는다. 
- 입력받은 횟수만큼 이동을 시행한다. 
    1. 0에서 9 사이의 


# 기능에 따른 클래스 구조

## playRacingGame Class
- domain 디렉터리내부의 RacingGame 클래스의 execute 함수를 실행함으로써 레이싱 게임을 시작한다. 

## RacingGame Class
- 자동차에 이름 부여(nameCars)
- 자동차 이름 검증(validateCarNames)
    1.  조건: 다섯 글자 이하
- 자동차 이동 횟수 부여(getNumberOfTrial), 검증(validateNaturalNumber)
    1. 자동차의 이동 횟수는 0이 아닌 자연수로 함
- 실행결과 출력(printRaceProcess)
- 자동차 경주 우승자 출력(printRaceResult)

## Car Class
- 자동차 전진시키기(move)
- 자동차 포지션 구하기(getPosition)