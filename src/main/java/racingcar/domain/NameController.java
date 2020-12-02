package racingcar.domain;

public class NameController {
    private NameController() {

    }

    public String[] splitNamebyComma(String name){
        String[] names = name.split(",");
        return names;
    }
}
