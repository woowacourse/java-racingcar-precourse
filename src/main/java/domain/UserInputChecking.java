package domain;

public class UserInputChecking {
    
    public boolean checkCarName(String n) {
	String[] tmpname = n.split(",");
	for(int i=0;i<tmpname.length;i++) {
	    if(tmpname[i].length()==0 || tmpname[i].length()>5) {
		System.out.println("자동차 이름이 잘못되었습니다.");
		return false;
	    }
	}
	return true;
    }
    
    public boolean checkCount(String n) {
	if(isStringInt(n)==false) {
	    System.out.println("횟수가 잘못 입력되었습니다. 정수만 입력해주세요.");
	    return false;
	}
	if( Integer.parseInt(n)<=0 ) {
	    System.out.println("횟수가 잘못 입력되었습니다. 양의 정수만 입력해주세요.");
	    return false;
	}
	return true;
    }
    
    public boolean isStringInt(String n) {
	 try {
	        Integer.parseInt(n);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
    }
}