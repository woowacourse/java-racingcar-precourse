## 구현 기능 목록

### 자동차 (Car)
- 임의의 숫자를 받아 전진하거나 멈추기 (moveRandomly)
- 자동차의 실행 결과를 출력 (toString)
- 자동차의 위치 비교 (compareTo)
- 자동차의 이름 반환 (getName)

### 입력 기능 (InputService)
- 자동차 이름을 입력받기 (getCarNames)
    * 각 이름 길이가 5 이하가 아닌 경우 예외 처리 (checkCarNames)
- 총 이동 횟수 입력받기 (getTotalPhaseNumber)
    * 숫자가 아닌 경우 예외 처리 (checkTotalPhaseNumber)
    * 양수가 아닌 경우 예외 처리 (checkTotalPhaseNumber)
    
### 게임 기능 (GameService)
- 특정 차수를 실행 (runPhase)
- 가장 멀리 간 자동차 한 대 찾기 (findOneOfWinners)
- 우승자들 결정 (findWinners)
- 우승자 안내 문구 출력 (showResult)

### Application
- 게임 실행 (runGame)