# 미션 - 자동차 경주 게임

## 1. UserInputGetter

### 1-1 자동차이름 받기
-이름 파싱

### 1-2 시도횟수 받기
-숫자만 받기

## 2. GameTools

### 2-1 무작위값 구하기
### 2-2 4이상인지 판단
-Car 클래스에 전달


## 3. Car

### 3-1 한칸 앞으로
### 3-2 위치 전달
-GamePrinter 클래스에 전달

## 4. GamePrinter

### 4-1 매 회차 출력
-Car 클래스에서 정보 받아오기

### 4-2 최종 우승자 출력
-GameTools 클래스에서 받아오기

## 5. UserInputValidator

### 5-1 Car 이름 5자 검증
### 5-2 시도횟수 숫자 검증

## 6. Game

### 6-1 stageProcess
-모든 차에 Car.goForward 반복
-GamePrinter.매 회차 출력 출력 Call
### 6-2 gameProcess
-스테이지를 시도횟수만큼 반복 실행
-스테이지 종료시 우승자 선정 Call
### 6-3 carMaker
-UserInputGetter.parseCarName 에서 나온 갯수만큼 Car class 생성
### 6-4 findChampion
-GamePrinter 클래스에 전달
