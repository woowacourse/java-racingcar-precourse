# 레이싱 경주 게임
***
### Car
1. isMovePosition 값을 이용해 위치를 이동시키고 출력하기(printCarPosition)
2. 최대 위치가 맞는지 아닌지 확인하기(collectMaxPosition) / boolean(반환)

### RacingCar
1. 게임 시작하기(gameStart)
2. 전체 차 이름 입력받기(totalCarsName) / String(반환)
3. 전체 횟수 입력받기(totalTryCounter) / int(반환)

### RacingCarGame
1. 이름 분리하기(RacingCarGame(String cars)) / 생성자
2. 자동차 이름 등록하기(registerCar(String cars)) / 생성자에서 움직이는 메소드
3. 게임 시작하기(startRacingGame())
4. 랜덤 값이 4이상 true, 3이하 false를 반환(isMovePosition) / boolean(반환)
5. 최대 위치 찾기(setMaxPosition)