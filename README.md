
class Game

- String[] getCarNames()
사용자로부터 받은 차 이름들을 가공된 형태로 반환한다.
InputHandler class의 getInput, parse, checkFaultyInput 함수를 사용한다.

- Car[] generateCarsByNames(String[] names)
names 속 name이 부여된 Car 객체를 names 개수만큼 생성한다.

- void doRace(Car[] cars, numOfRound)
cars의 position을 조작하고, round에 따른 결과를 사용자에게 보여준다.
Oracle class의 TellGoOrStop, showRoundResult 함수를 사용한다.

- void findAndShowChampions(Car[] cars)
cars 안에서 champion들을 선별하고 출력한다.
Oracle class의 findChampions, showChampions 함수를 사용한다.


class Oracle

- boolean tellGoOrStop(int TOP, int BOTTOM, int BOUNDARY)
BOUNDARY/(TOP-BOTTOM) 의 확률에 따라 true 아니면 false를 반환한다.

- void showRoundResult(Car[] cars)
cars의 position을 name:--(position수만큼 '-'출력) 형태로 출력한다.

- Car[] findChampions(Car[] cars)
cars 속에서 챔피언들을 찾는다.

- void showChampions(Car[] cars)
챔피언 차들의 이름을 출력한다.

- boolean checkLength(Vector<String> names, int MAX)
Vector 속 모든 String의 길이가 모두 MAX 이하면 true를 반환한다.

- boolean checkRepetition(Vector<String> names)
names 속에서 중복되는 문자열이 존재하는지 검사한다. 중복이 존재하면 true를 반환한다.
checkRepeatedName 함수를 사용한다.

- boolean checkRepeatedName(String specificName, Vector<String> names)
specificName이 vector에서 중복되는지 검사한다. 중복이 발견되면 true를 반환한다.
InputHandler.countName 함수를 사용한다.

- boolean checkEmptyString(Vector<String> names)
names의 size가 0인 경우 true를 반환한다.

- boolean checkFaultyInput
입력된 이름 길이가 6 이상인지, 빈 문자열인지, 중복되는 이름이 있는지 검사한다. 하나라도 맞다면 true를 반환한다.
checklength, checkRepetition, checkEmptyString 함수를 사용한다.




class InputHandler

- String getInput()
사용자로부터 입력을 받는다.

- Vector<String> parse(String input, String separator)
separator를 구분자로 이용해 input을 String 배열로 변환한다.
String 배열 중 빈 string을 제외한 나머지 string들을 vector 객체에 보관해서 vector 객체를 반환한다.

- int countName(String specificName, Vector<String> names)
sepecificName이 names안에 몇 개 있는지에 대한 정보를 반환한다.

- InputError findErrorReport(Vector<InputError> reports)
 reports 중 error report가 있는지 확인한다. error code 0인 report를 제외한 나머지는 모두 error report로 취급한다.
 여러 가지 error report가 함께 있다면 error report들 중 하나를 return한다.
 만약 error가 없다면 null을 리턴한다.


class InputReport


class InputReportCode


class InputReportMessage


class InputReportHandler

- Vector<InputReport> gatherReport(Vector<String> names, int max)
입력된 이름 길이가 6 이상인지, 빈 문자열인지, 중복되는 이름이 있는지 검사한다. 검사 후 생성된 InputError 객체들을 Vector에 모아서 리턴한다.
checklength, checkRepetition, checkEmptyString 함수를 사용한다.

-



*구현순서:
getInput -> parse -> checkLength -> countName -> checkRepeatedName -> checkRepetition -> checkEmptyString
-> checkFaultyInput -> getCarNames
-> generateCarsByNames -> tellGoOrStop -> showRoundResult -> doRace
->  findChampions -> showChampions -> findAndShowChampions