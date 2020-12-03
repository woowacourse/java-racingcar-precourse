# 🏎️ 자동차 경주 게임

## 구현 기능 목록

### 1. 자동차 입력
- 자동차 이름은 쉼표를 기준으로 구분
- 예외 발생
  - 5자보다 긴 경우

### 2. 시도 횟수 입력
- 예외 발생
  - 숫자가 아닌 경우

### 3. 전진/멈춤 결정
- RandomUtils 이용하여 자동차별 랜덤값 생성
- 전진 : 랜덤값이 0에서 3일 경우
- 멈춤 : 랜덤값이 4에서 9일 경우

### 4. 게임 차수별 결과 출력

### 5. 최종 우승자 출력
- 전진을 가장 많이 한 자동차가 우승
- 우승자는 여러명일 수 있음
