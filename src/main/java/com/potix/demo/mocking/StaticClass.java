package com.potix.demo.mocking;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticClass {
	private static final Logger LOG = LoggerFactory.getLogger(StaticClass.class);

	public static boolean aPublicMethod() {
		return aPrivateMethod(new Random().nextInt());
	}

	private static boolean aPrivateMethod(int i) {
		LOG.info("before aPrivateMethod");

		boolean isEven = i % 2 == 0;
		if (isEven) {
			LOG.info("{} is a even number.", i);
		} else {
			LOG.warn("{} is an odd number.", i);
		}

		return isEven;
	}
}
