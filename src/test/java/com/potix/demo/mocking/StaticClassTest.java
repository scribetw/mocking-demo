package com.potix.demo.mocking;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticClassTest {
	@Test
	public void aPrivateMethod(@Mocked final Logger logging) {
		// Mock up LoggerFactory.getLogger
		new MockUp<LoggerFactory>() {
			@Mock public Logger getLogger(Class clazz) {
				return logging;
			}
		};

		// Use reflection to call private static method
		try {
			Method m = StaticClass.class.getDeclaredMethod("aPrivateMethod", int.class);
			m.setAccessible(true);

			Object result = m.invoke(StaticClass.class, 2);
			assertTrue("The result must be true", (boolean) result);

			new Verifications() {{
				logging.info(anyString);
				logging.info(anyString, any);
			}};
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
