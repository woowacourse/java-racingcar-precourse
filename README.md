# 미션 - 자동차 경주 게임

## 1. UserInputGetter

### 1-1 getUserInput
### 1-2 parseCarName

## 2. GameTools

### 2-1 무작위값 구하기 - getRandomNumber
### 2-2 4이상인지 판단 - judgeMoreThan4
-Car 클래스에 전달


## 3. Car

### 3-1 한칸 앞으로 - goForward
### 3-2 위치 전달 - getPosition
-GamePrinter 클래스에 전달
### 3-3 이름 전달 - getName

## 4. GamePrinter

### 4-1 매 회차 출력 - stagePrint
-Game 클래스의 Car instance 정보 받아오기
### 4-2 최종 우승자 출력 - championPrint
-findChampion 메소드의 결과 받아오기
### 4-3 일회성 출력
- goToStagePrint
- getNumberPrint
- getNamePrint

## 5. UserInputValidator

### 5-1 Car 이름 5자 검증 - checkNameLength
### 5-2 시도횟수 숫자 검증 - checkInt

## 6. Game

### 6-1 initGame
-car 이름 받기(예외처리)
-car instance 생성
-시도 횟수 받기

### 6-2 endGame
-우승자 선정

### 6-3 gameProcess
- init,endGame call
- 각 stage 진행
