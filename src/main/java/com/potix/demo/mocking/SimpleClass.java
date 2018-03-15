package com.potix.demo.mocking;

public class SimpleClass {
	private final SimpleService service;

	public SimpleClass(SimpleService service) {
		this.service = service;
	}

	public boolean isLucky() {
		return service.generateLuckyNumber() == getLuckyNumber();
	}

	private int getLuckyNumber() {
		return 7;
	}
}
