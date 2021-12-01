# 미션 - 자동차 경주 게임
## 🚀 기능 목록
### 자동차
- 이동
  - [x] 무작위 값이 4이상인 경우 전진
  - [ ] 무작위 값이 4미만인 경우 정지

### 입력 작업
- 경주할 자동차 이름 입력
  - [ ] 입력 안내문 출력
    ```
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    ```
  - [ ] 한 줄로 자동차 이름 입력
    ```
    pobi,woni,jun
    ```
  - [ ] 콤마로 자동차 이름 구분
  - [ ] 5글자 이하로만 구성
- 시도할 회수 입력
  - [ ] 자동차 이름 이후 입력
  - [ ] 입력 안내문 출력
    ```
    시도할 회수는 몇회인가요?
    ```
  - [ ] 숫자로 입력
    ```
    5
    ```
- 잘못 입력 시 처리
  - [ ] 내부에서 IllegalArgumentException 발생
  - [ ] 다시 재입력 처리
  
### 출력 작업
- 각 차수별 결과 출력
  - [ ] 자동차 별 중간 결과 생성
  - [ ] 자동차 별 중간 결과 출력
    ```
    pobi : --
    woni : ----
    jun : ---
    ```
- 우승자 출력
  - [ ] 단독 우승
    ```
    최종 우승자 : pobi
    ```
  - [ ] 공동 우승
    ```
    최종 우승자 : pobi, jun
    ```
- 에러 문구 출력
  - [ ] [ERROR]로 에러 문구 시작
    ```
    [ERROR] 시도 횟수는 숫자여야 한다.
    ```
