package model;

import java.util.ArrayList;

enum NumberListIntEnums {
	THRESHOLD(3);
	private final int value;

	NumberListIntEnums(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}

public class NumberList {
	private ArrayList<Number> numberList;

	public NumberList(int size) {
		this.numberList = new ArrayList<>();
		for (int nowSize = 0; nowSize < size; nowSize++) {
			this.numberList.add(new Number());
		}
	}
}
